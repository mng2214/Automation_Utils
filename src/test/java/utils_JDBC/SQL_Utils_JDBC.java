package utils_JDBC;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Utils_JDBC {
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;

    private static Statement establishConnection() {
        try {
            connection = DriverManager.getConnection(
                    getProp("connection_string"),
                    getProp("username"),
                    getProp("password"));
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException ex) {
            throw new RuntimeException("Can not connect to DB");
        }
        return statement;
    }

    private static String getProp(String key) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("src/test/resources/database.properties")));
        } catch (IOException ex) {
            throw new RuntimeException("Can not file properties file");
        }
        return properties.getProperty(key);
    }

    public static ResultSet queryDB(String query) {
        Statement statement1 = establishConnection();
        try {
            resultSet = statement1.executeQuery(query);
            return resultSet;
        } catch (SQLException ex) {
            throw new RuntimeException("Failed to execute query");
        } finally {
            closeConnection();
        }
    }

    private static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
            if (connection != null) {
                statement.close();
            }
            if (connection != null) {
                resultSet.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
