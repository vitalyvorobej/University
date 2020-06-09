package javaTest;

import dao.StudentDAO;
import model.StudentModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {
    private StudentDAO studentDAO = new StudentDAO();

    @Test
    void insert() {
        StudentModel studentModel = new StudentModel("Holm", "Grip", 6);
        studentDAO.insert(studentModel);
    }

    @Test
    void selectAll() {
        assertFalse(studentDAO.selectAll().isEmpty());
    }

    @Test
    void isDeleted() {
        assertTrue(studentDAO.isDeleted(5));
    }

    @Test
    void isUpdated() {
        StudentModel studentModel = new StudentModel(1, "Grem", "Depr", 5);
        assertTrue(studentDAO.isUpdated(studentModel));
    }
}