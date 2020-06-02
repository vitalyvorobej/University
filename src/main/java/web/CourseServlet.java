package web;

import dao.CourseDAO;
import model.CourseModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@WebServlet("/courseServlet")
public class CourseServlet extends HttpServlet {
    private CourseDAO courseDAO;
    private SimpleDateFormat format;
    private Date dateStart;
    private Date dateEnd;

    public void init() {
        courseDAO = new CourseDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      /*  format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        String courseName = request.getParameter("course_name");
        int teacherId = Integer.parseInt(request.getParameter("teacher_id"));
        String courseStartDate = request.getParameter("course_start_date");
        String courseEndDate = request.getParameter("course_end_date");
        try {
            dateStart = format.parse(courseStartDate);
            dateEnd = format.parse(courseEndDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        CourseModel courseModel = new CourseModel(courseName, teacherId, dateStart, dateEnd);
        CourseDAO courseDAO = new CourseDAO();
        courseDAO.insert(courseModel);
        request.getRequestDispatcher("/test/views/login/login.jsp").forward(request, response);//TODO change path
*/
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String action = request.getServletPath();
        switch (action) {*/
           /* case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertCourse(request, response);
                break;
            case "/delete":
                deleteCourse(request, response);
                break;
            case "/edit":
                showEditCourse(request, response);
                break;
            case "/update":
                updateCourse(request, response);
                break;*/
            /*default:
                listCourse(request, response);
                break;
        }*/
        listCourse(request, response);
    }

    private void listCourse(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<CourseModel> listCourse = courseDAO.selectAll();
        request.setAttribute("listCourse", listCourse);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/test/views/course/course-list.jsp");
        dispatcher.forward(request, response);
    }
}
