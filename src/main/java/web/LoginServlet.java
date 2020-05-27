package web;

import dao.UserTableDAO;
import model.UserTableModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserTableModel userTableModel = new UserTableModel();
        userTableModel.setLogin(login);
        userTableModel.setPassword(password);
        UserTableDAO userTableDAO = new UserTableDAO();
        try {
            String userValidate = userTableDAO.authenticateUser(userTableModel);
            if (userValidate.equals("Admin")) {
                System.out.println("Admins home");
                HttpSession session = request.getSession();
                session.setAttribute("Admin", login);
                request.setAttribute("login", login);
                request.getRequestDispatcher("/test/views/userTableRoles/Admin.jsp").forward(request, response);

            } else if (userValidate.equals("Teacher")) {
                System.out.println("Teacher home");
                HttpSession session = request.getSession();
                session.setAttribute("Teacher", login);
                request.setAttribute("login", login);
                request.getRequestDispatcher("/test/views/userTableRoles/Teacher.jsp").forward(request, response);
            } else if (userValidate.equals("Student")) {
                System.out.println("Student home");
                HttpSession session = request.getSession();
                session.setAttribute("Student", login);
                request.setAttribute("login", login);
                request.getRequestDispatcher("/test/views/userTableRoles/Student.jsp").forward(request, response);
            } else {
                System.out.println("Error message = " + userValidate);
                request.setAttribute("errMessage", userValidate);
                request.getRequestDispatcher("/test/views/login/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
