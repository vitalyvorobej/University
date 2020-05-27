package web;

import dao.TeacherDAO;
import model.TeacherModel;
import model.UserTableModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teacherName = request.getParameter("teacher_name");
        String teacherSecondName = request.getParameter("teacher_second_name");
        int userTableId = Integer.parseInt(request.getParameter("user_table_id"));
        TeacherModel teacherModel = new TeacherModel(teacherName, teacherSecondName, userTableId);
        TeacherDAO teacherDAO = new TeacherDAO();
        teacherDAO.insert(teacherModel);
        request.getRequestDispatcher("/test/views/login/login.jsp").forward(request, response);//TODO change path

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
