package javaTest;

import dao.CourseStudentDAO;
import model.CourseStudentModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseStudentDAOTest {
    private CourseStudentDAO courseStudentDAO = new CourseStudentDAO();

    @Test
    void insert() {
        CourseStudentModel courseStudentModel = new CourseStudentModel(3, "5", 3);
        courseStudentDAO.insert(courseStudentModel);
    }

    @Test
    void selectAll() {
        assertFalse(courseStudentDAO.selectAll().isEmpty());
    }

    @Test
    void isDeleted() {
        assertTrue(courseStudentDAO.isDeleted(3));
    }

    @Test
    void isUpdated() {
        CourseStudentModel courseStudentModel = new CourseStudentModel(1, "7", 2);
        assertTrue(courseStudentDAO.isUpdated(courseStudentModel));
    }
}