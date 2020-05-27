package web;

import dao.StudentDAO;
import dao.TeacherDAO;
import model.StudentModel;
import model.TeacherModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentName = request.getParameter("student_name");
        String studentSecondName = request.getParameter("student_second_name");
        int userTableId = Integer.parseInt(request.getParameter("user_table_id"));
        StudentModel studentModel = new StudentModel(studentName, studentSecondName, userTableId);
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.insert(studentModel);
        request.getRequestDispatcher("/test/views/login/login.jsp").forward(request, response);//TODO change path

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
