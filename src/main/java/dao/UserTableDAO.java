package dao;

import model.UserTableModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Виталий Воробей
 * * Класс для работы с таблицей user_table с использованием SQL команд:
 * {@value SELECT_USER_BY_ID}   - select данных по ID из таблицы user_table
 * * {@value INSERT} - вставка данных в таблицу user_table
 * * {@value SELECT_ALL} - выбрать все записи из таблицы user_table
 * * {@value DELETE_BY_ID} - удаление записи из таблицы user_table с помощью id-записи
 * * {@value UPDATE_BY_ID} - изменение записи в таблицы user_table с использование id-записи
 * * {@value DELETE_ALL} - удаление всех записей из таблицы user_table
 */
public class UserTableDAO extends AConnectToDb {
    private static final String INSERT = "INSERT INTO user_table" + "(login,password,role) VALUES " + "(?,?,?)";
    private static final String SELECT_USER_BY_ID = "SELECT user_table_id,login,password,role FROM user_table WHERE user_table_id=?";
    private static final String SELECT_ALL = "SELECT * from user_table";
    private static final String DELETE_BY_ID = "DELETE from user_table where user_table_id=?";
    private static final String UPDATE_BY_ID = "UPDATE user_table set login = ?, password = ?, role = ? where user_table_id =?";
    private static final String SELECT_USER_FOR_AUTHENTICATE = "SELECT login,password,role FROM user_table";
    private static final String DELETE_ALL = "DELETE from user_table";

    public UserTableDAO() {
    }

    /**
     * Метод для валидаци Role пользователя.
     */
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
                if (login.equals(userNameDB) && password.equals(passwordDB) && (roleDB.equals("Admin"))) {
                    return "Admin";
                } else if
                (login.equals(userNameDB) && password.equals(passwordDB) && (roleDB.equals("Teacher"))) {
                    return "Teacher";
                } else if
                (login.equals(userNameDB) && password.equals(passwordDB) && (roleDB.equals("Student"))) {
                    return "Student";
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return "wrong login or password";
    }


    public void insert(UserTableModel user) {
        try (Connection connection = createConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
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
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(SELECT_ALL)) {
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

    public boolean isDeletedById(int userTableId) {
        boolean isRowDeleted = false;
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(DELETE_BY_ID)) {
            ps.setInt(1, userTableId);
            isRowDeleted = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return isRowDeleted;
    }

    public boolean isUpdatedById(UserTableModel userTableModel) {
        boolean isRowUpdated = false;
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(UPDATE_BY_ID)) {
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

    public void deleteAll() {
        try (Connection connection = createConnection(); PreparedStatement ps = connection.prepareStatement(DELETE_ALL)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

}