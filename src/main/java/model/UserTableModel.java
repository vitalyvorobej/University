package model;


/**
 * Класс-модель описывающая таблицу user_table
 */
public class UserTableModel {

    private int userTableId;
    private String login;
    private String password;
    private String role;

    public UserTableModel() {
        super();
    }


    public UserTableModel(String login, String password, String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public UserTableModel(int userTableId, String login, String password, String role) {
        this.userTableId = userTableId;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getUserTableId() {
        return userTableId;
    }

    public void setUserTableId(int userTableId) {
        this.userTableId = userTableId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserTableModel{" +
                "userTableId=" + userTableId +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
