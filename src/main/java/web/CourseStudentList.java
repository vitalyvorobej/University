package web;

import dao.CourseStudentDAO;
import dao.StudentDAO;
import model.CourseStudentModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CourseStudentList")
public class CourseStudentList extends HttpServlet {
    private CourseStudentDAO courseStudentDAO;

    public void init() {
        courseStudentDAO = new CourseStudentDAO();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCourseStudent(request, response);
    }

    private void listCourseStudent(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        /*List<CourseStudentModel> listStudent = courseStudentDAO.selectAll();*/
        List<CourseStudentModel> listStudent = courseStudentDAO.selectWithCoursId();
        request.setAttribute("listStudent", listStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/views/coursestudent/course-student-list.jsp");
        dispatcher.forward(request, response);
    }
}
