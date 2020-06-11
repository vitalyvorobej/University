package javaTest;

import dao.*;
import model.UserTableModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTableDAOTest extends AConnectToDb {
    private UserTableDAO userTableDAO = new UserTableDAO();

    @Test
    void insert() {
        UserTableModel userTableModel = new UserTableModel("Admin@Login.com", "password", "Admin");
        UserTableModel userTableModel1 = new UserTableModel("Teacher@login.com", "password", "Teacher");
        UserTableModel userTableModel2 = new UserTableModel("Student@login.com", "password", "Student");
        userTableDAO.insert(userTableModel);
        userTableDAO.insert(userTableModel1);
        userTableDAO.insert(userTableModel2);
    }

    @Test
    void selectAll() {
        assertFalse(userTableDAO.selectAll().isEmpty());
    }


}