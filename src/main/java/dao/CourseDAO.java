package dao;

import model.CourseModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO extends AConnectToDb {
    private static final String INSERT = "INSERT INTO course"
            + "(course_name,teacher_id,course_start_date,course_end_date) VALUES "
            + "(?,?,?,?)";
    private static final String SELECT_BY_ID = "SELECT course_id,course_name,teacher_id,course_start_date,course_end_date " +
            "FROM course WHERE course_id=?";
    private static final String SELECT_ALL = "SELECT * from course";
    private static final String DELETE = "DELETE from course where course_id=?";
    private static final String UPDATE = "UPDATE course set course_name = ?, teacher_id = ?, course_start_date = ?, course_end_date = ? where course_id =?";

    public CourseDAO() {
    }

    public void insert(CourseModel courseModel) {
        try (Connection connection = createConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
            try {
                ps.setString(1, courseModel.getCourseName());
                ps.setInt(2, courseModel.getTeacher().getTeacherId());
                ps.setObject(3, courseModel.getCourseStartDate(), Types.TIMESTAMP);
                ps.setObject(4, courseModel.getCourseEndDate(), Types.TIMESTAMP);
                ps.executeUpdate();


                final ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                final int id = rs.getInt("course_id");

                rs.close();
                courseModel.setCourseId(id);
                connection.commit();
            } catch (Exception e) {
                connection.rollback();
                throw new RuntimeException(e);
            }


        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public CourseModel select(int courseId) {
        CourseModel courseModel = null;
        try (Connection connection = createConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_BY_ID, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String courseName = rs.getString("course_name");
                int teacherId = rs.getInt("teacher_id");
                Date startDate = rs.getDate("course_start_date");
                Date endDate = rs.getDate("course_end_date");
                courseModel = new CourseModel(courseId, courseName, teacherId, startDate, endDate);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }


        return courseModel;
    }

    public List<CourseModel> selectAll() {
        List<CourseModel> listCourses = new ArrayList<>();
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int courseId = rs.getInt("course_id");
                String courseName = rs.getString("course_name");
                int teacherId = rs.getInt("teacher_id");
                Date courseStartDate = rs.getDate("course_start_date");
                Date courseEndDate = rs.getDate("course_end_date");
                listCourses.add(new CourseModel(courseId, courseName, teacherId, courseStartDate, courseEndDate));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }


        return listCourses;
    }

    public boolean isDeleted(int courseId) {
        boolean isCourseDeleted = false;
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, courseId);
            if (ps.executeUpdate() > 0) {
                isCourseDeleted = true;
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return isCourseDeleted;
    }

    public boolean isuPdated(CourseModel courseModel) {
        boolean isRowUpdated = false;
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, courseModel.getCourseName());
            ps.setInt(2, courseModel.getCourseId());
            ps.setObject(3, courseModel.getCourseStartDate());
            ps.setObject(4, courseModel.getCourseEndDate());
            ps.setInt(5, courseModel.getCourseId());
            isRowUpdated = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return isRowUpdated;
    }
}
