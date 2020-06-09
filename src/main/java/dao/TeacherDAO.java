package dao;

import model.TeacherModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Виталий Воробей
 * * Класс для работы с таблицей teacher с использованием SQL команд:
 * {@value SELECT_BY_ID}   - select данных по ID из таблицы teacher
 * * {@value INSERT} - вставка данных в таблицу teacher
 * * {@value SELECT_ALL} - выбрать все записи из таблицы teacher
 * * {@value DELETE_BY_ID} - удаление записи из таблицы teacher с помощью id-записи
 * * {@value UPDATE_BY_ID} - изменение записи в таблицы teacher с использование id-записи
 * * {@value DELETE_ALL} - удаление всех записей из таблицы teacher
 */
public class TeacherDAO extends AConnectToDb {
    private static final String INSERT = "INSERT INTO teacher"
            + "(teacher_name,teacher_second_name,user_table_id) VALUES "
            + "(?,?,?)";
    private static final String SELECT_BY_ID = "SELECT teacher_id,teacher_name,teacher_second_name,user_table_id " +
            "FROM teacher WHERE teacher_id=?";

    private static final String SELECT_ALL = "SELECT * from teacher";
    private static final String DELETE_BY_ID = "DELETE from teacher where teacher_id=?";
    private static final String UPDATE_BY_ID = "UPDATE teacher set teacher_name = ?, teacher_second_name = ?, user_table_id = ? where teacher_id =?";
    private static final String DELETE_ALL = "DELETE from teacher";

    public TeacherDAO() {
    }

    public void insert(TeacherModel teacherModel) {
        try (Connection connection = createConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
            try {
                ps.setString(1, teacherModel.getTeacherName());
                ps.setString(2, teacherModel.getTeacherSecondName());
                ps.setInt(3, teacherModel.getUserTableModel().getUserTableId());
                ps.executeUpdate();


                final ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                final int id = rs.getInt("teacher_id");

                rs.close();

                teacherModel.setTeacherId(id);
                connection.commit();
            } catch (Exception e) {
                connection.rollback();
                throw new RuntimeException(e);
            }


        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public TeacherModel select(int teacherId) {
        TeacherModel teacherModel = null;
        try (Connection connection = createConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, teacherId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String teacherName = rs.getString("teacher_name");
                String teacherSecondName = rs.getString("teacher_second_name");
                int userTableId = rs.getInt("user_table_id");
                teacherModel = new TeacherModel(teacherId, teacherName, teacherSecondName, userTableId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }


        return teacherModel;
    }

    public List<TeacherModel> selectAll() {
        List<TeacherModel> listTeachers = new ArrayList<>();
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int teacherId = rs.getInt("teacher_id");
                String teacherName = rs.getString("teacher_name");
                String teacherSecondName = rs.getString("teacher_second_name");
                int userTableId = rs.getInt("user_table_id");
                listTeachers.add(new TeacherModel(teacherId, teacherName, teacherSecondName, userTableId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }


        return listTeachers;
    }

    public boolean isDeleted(int teacherId) {
        boolean isFieldDeleted = false;
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(DELETE_BY_ID)) {
            ps.setInt(1, teacherId);
            if (ps.executeUpdate() > 0) {
                isFieldDeleted = true;
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return isFieldDeleted;
    }


    public boolean isUpdated(TeacherModel teacherModel) {
        boolean isRowUpdated = false;
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(UPDATE_BY_ID)) {
            ps.setString(1, teacherModel.getTeacherName());
            ps.setString(2, teacherModel.getTeacherSecondName());
            ps.setInt(3, teacherModel.getUserTableId());
            ps.setInt(4, teacherModel.getTeacherId());
            isRowUpdated = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return isRowUpdated;
    }

    public void deleteAll() {
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(DELETE_ALL)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

}
