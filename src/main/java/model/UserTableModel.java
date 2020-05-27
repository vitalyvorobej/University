package model;

import javax.validation.constraints.Size;

public class UserTableModel {

    private int userTableId;
    @Size(min = 5, max = 40)
    private String login;
    @Size(min = 5, max = 20)
    private String password;
    @Size(min = 5, max = 10)
    private String role;

    public UserTableModel() {
        super();
    }



    public UserTableModel(@Size(min = 5, max = 40) String login, @Size(min = 5, max = 20) String password, @Size(min = 5, max = 10) String role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public UserTableModel(int userTableId, @Size(min = 5, max = 40) String login, @Size(min = 5, max = 20) String password, @Size(min = 5, max = 10) String role) {
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


}
