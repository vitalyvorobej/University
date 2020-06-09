package javaTest;

import dao.TeacherDAO;
import model.TeacherModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeacherDAOTest {
    private TeacherDAO teacherDAO = new TeacherDAO();

    @Test
    void insert() {
        TeacherModel teacherModel = new TeacherModel("Alex", "Sov", 5);
        teacherDAO.insert(teacherModel);
    }

    @Test
    void update() {
        TeacherModel teacherModel = new TeacherModel(1, "Alex", "Dmitriev", 2);
        assertTrue(teacherDAO.isUpdated(teacherModel));
    }


    @Test
    void selectAll() {
        assertFalse(teacherDAO.selectAll().isEmpty());
    }

    @Test
    void delete() {
        assertTrue(teacherDAO.isDeleted(5));
    }
}
