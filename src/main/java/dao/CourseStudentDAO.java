package dao;

import model.CourseStudentModel;
import model.StudentModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseStudentDAO extends AConnectToDb {
    private static final String INSERT = "INSERT INTO course_students(student_id,mark,course_id)" + "VALUES" + "(?,?,?)";
    private static final String SELECT_BY_ID = "SELECT student_id,mark,course_id" + "FROM course_students WHERE student_id = ? ";
    private static final String SELECT_ALL = "SELECT * FROM course_students";
    private static final String DELETE = "DELETE FROM course_students where student_id=?";
    private static final String UPDATE = "UPDATE course_students set mark = ?, course_id = ? where student_id =?";

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
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(DELETE)) {
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
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, courseStudentModel.getMark());
            ps.setInt(2, courseStudentModel.getCourseId());
            ps.setInt(3, courseStudentModel.getStudentId());
            isRowUpdated = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return isRowUpdated;
    }

}
