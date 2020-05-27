package web;

import dao.CourseStudentDAO;
import dao.TeacherDAO;
import model.CourseStudentModel;
import model.TeacherModel;

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
        courseStudentDAO.insert(courseStudentModel);
        request.getRequestDispatcher("/test/views/login/login.jsp").forward(request, response);//TODO change path

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
