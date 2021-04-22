package utilities;

import java.sql.*;
import java.util.Arrays;

public class DataBaseConnector {
    private static final String dbusername = "postgres";
    private static final String dbpassword = "Mczo.0414";
    private static final String connectionUrl = "jdbc:postgresql://localhost:5432/";

    private static Connection connection;
    private static ResultSet resultSet;
    private static ResultSetMetaData metaData;
    private static PreparedStatement preparedStatement;

    public static Connection createConnection() {
        try {
            connection = DriverManager.getConnection(connectionUrl,dbusername,dbpassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // =========== get Resultset with query =========== //
    public static ResultSet executeQuery(String query) {

        createConnection();
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(query + ": query did not successfully execute!" );
        }
        return resultSet;
    }

    public static ResultSet getResultSet(String query) {

        try {
            connection = DriverManager.getConnection(connectionUrl, dbusername, dbpassword);
            if (connection != null) {
                System.out.println("EN: Connected to the database...");
                System.out.println("TR: Database e baglanildi...");
            } else {
                System.out.println("EN: Database connection failed");
                System.out.println("TR: Database baglantisi kurulamadi.");
            }

            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(query);

        } catch (SQLException sqlEx) {
            System.out.println("SQL Exception:" + Arrays.toString(sqlEx.getStackTrace()));
        }
        return resultSet;
    }
}
