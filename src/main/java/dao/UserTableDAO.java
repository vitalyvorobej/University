package dao;

import model.UserTableModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserTableDAO extends AConnectToDb {
    private static final String INSERT_USER_SQL = "INSERT INTO user_table"
            + "(/*user_table_id,*/login,password,role) VALUES "
            + "(/*NEXTVAL('user_table_user_table_id_seq'),*/?,?,?)";
    private static final String SELECT_USER_BY_ID = "SELECT user_table_id,login,password,role FROM user_table WHERE user_table_id=?";
    private static final String SELECT_ALL_USERS = "SELECT * from user_table";
    private static final String DELETE_USER_SQL = "DELETE from user_table where user_table_id=?";
    private static final String UPDATE_USER_SQL = "UPDATE user_table set login = ?, password = ?, role = ? where user_table_id =?";
    private static final String SELECT_USER_FOR_AUTHENTICATE = "SELECT login,password,role FROM user_table";

    public UserTableDAO() {
    }

    public String authenticateUser(UserTableModel loginUser) {
        String login = loginUser.getLogin();
        String password = loginUser.getPassword();
        Connection con;
        Statement statement;
        ResultSet resultSet;

        String userNameDB;
        String passwordDB;
        String roleDB;
        try {
            con = createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery(SELECT_USER_FOR_AUTHENTICATE);

            while (resultSet.next()) {
                userNameDB = resultSet.getString("login");
                passwordDB = resultSet.getString("password");
                roleDB = resultSet.getString("role");
                if (login.equals(userNameDB) && password.equals(passwordDB) && (roleDB.equals("Admin")))
                    return "Admin";
                else if (login.equals(userNameDB) && password.equals(passwordDB) && (roleDB.equals("Teacher")))
                    return "Teacher";
                else if (login.equals(userNameDB) && password.equals(passwordDB) && (roleDB.equals("Student")))
                    return "Student";
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return "wrong login or password";
    }


    public void insert(UserTableModel user) {
        try (Connection connection = createConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL, Statement.RETURN_GENERATED_KEYS)) {
            connection.setAutoCommit(false);
            try {
                ps.setString(1, user.getLogin());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getRole());
                ps.executeUpdate();


                final ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                final int id = rs.getInt("user_table_id");

                rs.close();

                user.setUserTableId(id);
                connection.commit();
            } catch (Exception e) {
                connection.rollback();
                throw new RuntimeException(e);

            }

        } catch (SQLException exception) {
            printSQLException(exception);
        }
    }

    public UserTableModel select(int userTableId) {
        UserTableModel userTableModel = null;
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_ID)) {
            ps.setInt(1, userTableId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String login = rs.getString("login");
                String password = rs.getString("password");
                String role = rs.getString("role");
                userTableModel = new UserTableModel(userTableId, login, password, role);
            }


        } catch (SQLException e) {
            printSQLException(e);
        }
        return userTableModel;
    }

    public List<UserTableModel> selectAll() {
        List<UserTableModel> listUsers = new ArrayList<>();
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(SELECT_ALL_USERS)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int user_table_id = rs.getInt("user_table_id");
                String login = rs.getString("login");
                String password = rs.getString("password");
                String role = rs.getString("role");
                listUsers.add(new UserTableModel(user_table_id, login, password, role));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }


        return listUsers;
    }

    public boolean isDeleted(int userTableId) {
        boolean isRowDeleted = false;
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(DELETE_USER_SQL)) {
            ps.setInt(1, userTableId);
            isRowDeleted = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return isRowDeleted;
    }

    public boolean isUpdated(UserTableModel userTableModel) {
        boolean isRowUpdated = false;
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(UPDATE_USER_SQL)) {
            ps.setString(1, userTableModel.getLogin());
            ps.setString(2, userTableModel.getPassword());
            ps.setString(3, userTableModel.getRole());
            ps.setInt(4, userTableModel.getUserTableId());
            isRowUpdated = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return isRowUpdated;
    }

}