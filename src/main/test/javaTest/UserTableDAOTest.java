package javaTest;

import dao.*;
import model.UserTableModel;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTableDAOTest extends AConnectToDb {
    private UserTableDAO userTableDAO = new UserTableDAO();
    private TeacherDAO teacherDAO = new TeacherDAO();
    private StudentDAO studentDAO = new StudentDAO();
    private CourseStudentDAO courseStudentDAO = new CourseStudentDAO();
    private CourseDAO courseDAO = new CourseDAO();
/*
    @Before
    public void clearDB() {
        courseStudentDAO.deleteAll();
        teacherDAO.deleteAll();
        studentDAO.deleteAll();
        userTableDAO.deleteAll();

    }*/

    @Test
    void insert() {
        UserTableModel userTableModel = new UserTableModel("TestLogin", "password", "Teacher");
        userTableDAO.insert(userTableModel);
    }

    @Test
    void authenticateUser() {
        assertEquals("Admin", userTableDAO.authenticateUser(userTableDAO.select(1)));
        assertEquals("Teacher", userTableDAO.authenticateUser(userTableDAO.select(2)));
        assertEquals("Student", userTableDAO.authenticateUser(userTableDAO.select(5)));
    }


    @Test
    void selectAll() {
        assertFalse(userTableDAO.selectAll().isEmpty());
    }

  /*  @Test
    void isDeletedById() {
        assertTrue(userTableDAO.isDeletedById(3));
        assertTrue(userTableDAO.isDeletedById(4));

    }*/

    /*@Test
    void isUpdated() {
        UserTableModel userTableModel = new UserTableModel(1, "updateLogin", "UpdatePassword", "StudentT");
        UserTableModel userTableModel1 = new UserTableModel(2, "updateTestLogin1", "updatepassword1", "TeacherT");

        assertTrue(userTableDAO.isUpdatedById(userTableModel));
        assertTrue(userTableDAO.isUpdatedById(userTableModel1));

    }*/

  /*  @Test
    void deleteAll() {
        courseStudentDAO.deleteAll();
        courseDAO.deleteAll();
        teacherDAO.deleteAll();
        studentDAO.deleteAll();
        userTableDAO.deleteAll();
        courseDAO.selectAll();
        assertTrue(userTableDAO.selectAll().isEmpty());
    }*/
}