package web;

import dao.CourseStudentDAO;
import model.CourseStudentModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/courseStudentServlet")
public class CourseStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int studentId = Integer.parseInt(request.getParameter("student_id"));
        String mark = request.getParameter("mark");
        int courseId = Integer.parseInt(request.getParameter("course_id"));
        CourseStudentModel courseStudentModel = new CourseStudentModel(studentId, mark, courseId);
        CourseStudentDAO courseStudentDAO = new CourseStudentDAO();
        courseStudentDAO.isUpdated(courseStudentModel);
        request.getRequestDispatcher("/pages/views/coursestudent/complite.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}
