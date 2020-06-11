package javaTest;

import dao.StudentDAO;
import model.StudentModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {
    private StudentDAO studentDAO = new StudentDAO();

    @Test
    void insert() {
        StudentModel studentModel = new StudentModel("Holm", "Grip", 1);
        studentDAO.insert(studentModel);
    }

    @Test
    void selectAll() {
        assertFalse(studentDAO.selectAll().isEmpty());
    }



}