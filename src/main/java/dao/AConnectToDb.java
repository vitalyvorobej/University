package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Виталий Воробей
 * Абстрактный класс для создания подключения к базе данных.
 * База данных - PosgreSQL
 */
public abstract class AConnectToDb {
    private static final Logger LOGGER = Logger.getLogger(AConnectToDb.class);

    /**
     * Метод для создание подключения с использованием url,password,dbDriver.
     *
     * @return connection
     */
    public static Connection createConnection() {
        Connection con = null;
        /*String dbUrl = "jdbc:postgresql://localhost:5432/course-test";*/
        String dbUrl = "jdbc:postgresql://localhost:5432/course";
        String username = "postgres";
        String password = "postgres";
        String dbDriver = "org.postgresql.Driver";
        try {
            try {
                Class.forName(dbDriver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            con = DriverManager.getConnection(dbUrl, username, password);
            LOGGER.info("Post establishing a DB connection - " + con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * Метод для печати ошибок класса SQLException.
     */
    public void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                LOGGER.warn("SQLState: " + ((SQLException) e).getSQLState());
                LOGGER.warn("Error Code: " + ((SQLException) e).getErrorCode());
                LOGGER.warn("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    LOGGER.warn("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
