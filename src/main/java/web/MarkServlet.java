package web;

import dao.CourseStudentDAO;
import model.CourseStudentModel;
import model.UserTableModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/MarkServlet")
public class MarkServlet extends HttpServlet {
    private CourseStudentDAO courseStudentDAO;

    public void init() {
        courseStudentDAO = new CourseStudentDAO();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            updateCourseStudent(request, response);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    private void updateCourseStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int studentId = Integer.parseInt(request.getParameter("student_id"));
        String mark = request.getParameter("mark");
        int courseId = Integer.parseInt(request.getParameter("course_id"));
        CourseStudentModel updateCourseStudent = new CourseStudentModel(studentId, mark, courseId);
        courseStudentDAO.isUpdated(updateCourseStudent);
        response.sendRedirect("/test/views/coursestudent/complite.jsp");
    }
}
