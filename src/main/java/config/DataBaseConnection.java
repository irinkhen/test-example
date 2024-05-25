package config;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.System.getProperties;
import static java.lang.System.getProperty;
import static java.sql.DriverManager.getConnection;

public class DataBaseConnection {

    private Connection dbConnection;

    public Connection getDBConnection() throws ClassNotFoundException, SQLException, IOException {
        getProperties().load(ClassLoader.getSystemResourceAsStream("db.properties"));
        String dbHost = getProperty("dbHost");
        String dbPort = getProperty("dbPort");
        String dbName = getProperty("dbName");
        String dbUser = getProperty("dbUser");
        String dbPassword = getProperty("dbPassword");

        String connection = "jdbc:postgresql://" +
                dbHost + ":" +
                dbPort + "/" +
                dbName;

        dbConnection = getConnection(connection, dbUser, dbPassword);
        return dbConnection;
    }

    public String getSingleValueQuery(String query) {
        String result = "";
        try (ResultSet resultSet = getDBConnection().prepareStatement(query).executeQuery()) {
            if (resultSet.next()) {
                result = resultSet.getString(1);
            }
        } catch (SQLException | ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        } finally {
            closeConnection();
        }
        return result;
    }

    public void closeConnection() {
        try {
            dbConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
