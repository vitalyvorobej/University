package dao;

import model.CourseStudentModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Виталий Воробей
 * * Класс для работы с таблицей coursestudent с использованием SQL команд:
 * {@value SELECT_BY_ID}   - select данных по ID из таблицы courseStudent
 * * {@value INSERT} - вставка данных в таблицу courseStudent
 * * {@value SELECT_ALL} - выбрать все записи из таблицы courseStudent
 * * {@value DELETE_BY_ID} - удаление записи из таблицы courseStudent с помощью id-записи
 * * {@value UPDATE_BY_ID} - изменение записи в таблицы courseStudent с использование id-записи
 * * {@value DELETE_ALL} - удаление всех записей из таблицы courseStudent
 */
public class CourseStudentDAO extends AConnectToDb {
    private static final String INSERT = "INSERT INTO course_students(student_id,mark,course_id)" + "VALUES" + "(?,?,?)";
    private static final String SELECT_BY_ID = "SELECT student_id,mark,course_id" + "FROM course_students WHERE student_id = ? ";
    private static final String SELECT_ALL = "SELECT * FROM course_students";
    private static final String DELETE_BY_ID = "DELETE FROM course_students where student_id=?";
    private static final String UPDATE_BY_ID = "UPDATE course_students set student_id = ?, mark = ?, course_id = ? where student_id =?";
    private static final String DELETE_ALL = "DELETE from course_students";

    public CourseStudentDAO() {
    }


    public void insert(CourseStudentModel courseStudentModel) {
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(INSERT)) {
            connection.setAutoCommit(false);
            try {
                ps.setInt(1, courseStudentModel.getStudentModel().getStudentId());
                ps.setString(2, courseStudentModel.getMark());
                ps.setInt(3, courseStudentModel.getCourseModel().getCourseId());
                ps.executeUpdate();


                connection.commit();
            } catch (Exception e) {
                connection.rollback();
                throw new RuntimeException(e);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    public CourseStudentModel selectById(int studentId) {
        CourseStudentModel courseStudentModel = null;
        try (Connection connection = createConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID)) {
            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String mark = rs.getString("mark");
                int courseId = rs.getInt("course_id");
                courseStudentModel = new CourseStudentModel(studentId, mark, courseId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }


        return courseStudentModel;
    }

    public List<CourseStudentModel> selectAll() {
        List<CourseStudentModel> listCourseStudent = new ArrayList<>();
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int studentId = rs.getInt("student_id");
                String mark = rs.getString("mark");
                int courseId = rs.getInt("course_id");
                listCourseStudent.add(new CourseStudentModel(studentId, mark, courseId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }


        return listCourseStudent;
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

    public boolean isUpdated(CourseStudentModel courseStudentModel) {
        boolean isRowUpdated = false;
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(UPDATE_BY_ID)) {
            ps.setInt(1, courseStudentModel.getStudentId());
            ps.setString(2, courseStudentModel.getMark());
            ps.setInt(3, courseStudentModel.getCourseId());
            ps.setInt(4, courseStudentModel.getStudentId());

            isRowUpdated = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return isRowUpdated;
    }

    public boolean deleteAll() {
        boolean isDeleted = false;
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(DELETE_ALL)) {

            if (ps.executeUpdate() > 0) {
                isDeleted = true;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return isDeleted;
    }

}
