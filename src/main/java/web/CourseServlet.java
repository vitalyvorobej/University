package web;

import dao.CourseDAO;
import model.CourseModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@WebServlet("/courseServlet")
public class CourseServlet extends HttpServlet {
    SimpleDateFormat format;
    Date dateStart;
    Date dateEnd;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
