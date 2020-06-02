package web;

import dao.UserTableDAO;
import model.UserTableModel;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);

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
                LOGGER.info("login to admin page");
                HttpSession session = request.getSession();
                session.setAttribute("Admin", login);
                request.setAttribute("login", login);
                request.getRequestDispatcher("/test/views/userTableRoles/admin.jsp").forward(request, response);

            } else if (userValidate.equals("Teacher")) {
                LOGGER.info("login to teacher page");
                HttpSession session = request.getSession();
                session.setAttribute("Teacher", login);
                request.setAttribute("login", login);
                request.getRequestDispatcher("/test/views/userTableRoles/teacher.jsp").forward(request, response);
            } else if (userValidate.equals("Student")) {
                LOGGER.info("loggin to student page");
                HttpSession session = request.getSession();
                session.setAttribute("Student", login);
                request.setAttribute("login", login);
                request.getRequestDispatcher("/test/views/userTableRoles/student.jsp").forward(request, response);
            } else {
                LOGGER.warn("Error message = " + userValidate);
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
