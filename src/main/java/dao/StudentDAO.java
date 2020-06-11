package dao;

import model.StudentModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Виталий Воробей
 * * Класс для работы с таблицей student с использованием SQL команд:
 * {@value SELECT_BY_ID}   - select данных по ID из таблицы student
 * * {@value INSERT} - вставка данных в таблицу student
 * * {@value SELECT_ALL} - выбрать все записи из таблицы student
 * * {@value DELETE_BY_ID} - удаление записи из таблицы student с помощью id-записи
 * * {@value UPDATE_BY_ID} - изменение записи в таблицы student с использование id-записи
 * * {@value DELETE_ALL} - удаление всех записей из таблицы student
 */
public class StudentDAO extends AConnectToDb {
    private static final String INSERT = "INSERT INTO student"
            + "(student_name,student_second_name,user_table_id) VALUES "
            + "(?,?,?)";
    private static final String SELECT_BY_ID = "SELECT student_id,student_name,student_second_name,user_table_id " +
            "FROM student WHERE student_id=?";
    private static final String SELECT_ALL = "SELECT * from student";
    private static final String DELETE_BY_ID = "DELETE from student where student_id=?";
    private static final String UPDATE_BY_ID = "UPDATE student set student_name = ?, student_second_name = ?, user_table_id = ? where student_id =?";
    private static final String DELETE_ALL = "DELETE from student";
    private static final String GET_STUDENT_ID = "select student.student_id from student\n" +
            "join user_table\n" +
            "ON student.user_table_id = user_table.user_table_id WHERE login = ?;";


    public StudentDAO() {
    }


    public void insert(StudentModel studentModel) {
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
            try {
                ps.setString(1, studentModel.getStudentName());
                ps.setString(2, studentModel.getStudentSecondName());
                ps.setInt(3, studentModel.getUserTableModel().getUserTableId());
                ps.executeUpdate();

                final ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                final int id = rs.getInt("student_id");

                rs.close();

                studentModel.setStudentId(id);
                connection.commit();
            } catch (Exception e) {
                connection.rollback();
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public int getStudentIdByLogin(String login) {
        int id = 0;
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(GET_STUDENT_ID, Statement.RETURN_GENERATED_KEYS)) {
            StudentModel studentModel = null;

            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                studentModel = new StudentModel(studentId);
                id = studentModel.getStudentId();
            }
        } catch (SQLException e) {
            printSQLException(e);
        }

        return id;
    }

    public StudentModel select(int studentId) {
        StudentModel studentModel = null;
        try (Connection connection = createConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String studentName = rs.getString("student_name");
                String studentSecondName = rs.getString("student_second_name");
                int userTableId = rs.getInt("user_table_id");
                studentModel = new StudentModel(studentId, studentName, studentSecondName, userTableId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }


        return studentModel;
    }


    public List<StudentModel> selectAll() {
        List<StudentModel> listStudent = new ArrayList<>();
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                String studentName = rs.getString("student_name");
                String studentSecondName = rs.getString("student_second_name");
                int userTableId = rs.getInt("user_table_id");
                listStudent.add(new StudentModel(studentId, studentName, studentSecondName, userTableId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }


        return listStudent;
    }

    public boolean isDeleted(int studentId) {
        boolean isFieldDeleted = false;
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(DELETE_BY_ID)) {
            ps.setInt(1, studentId);
            if (ps.executeUpdate() > 0) {
                isFieldDeleted = true;
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return isFieldDeleted;
    }


    public boolean isUpdated(StudentModel studentModel) {
        boolean isRowUpdated = false;
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(UPDATE_BY_ID)) {
            ps.setString(1, studentModel.getStudentName());
            ps.setString(2, studentModel.getStudentSecondName());
            ps.setInt(3, studentModel.getUserTableId());
            ps.setInt(4, studentModel.getStudentId());
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
