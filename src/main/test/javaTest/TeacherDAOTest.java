package javaTest;

import dao.TeacherDAO;
import model.TeacherModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeacherDAOTest {
    private TeacherDAO teacherDAO = new TeacherDAO();

    @Test
    void insert() {
        TeacherModel teacherModel = new TeacherModel("Alex", "Sov", 1);
        teacherDAO.insert(teacherModel);
    }


    @Test
    void selectAll() {
        assertFalse(teacherDAO.selectAll().isEmpty());
    }


}
