package Connectivity;

import java.sql.*;


public class ConnectionClass {
    public Connection connection;
    public Connection getConnection() {


        String dbName = "stockmarket";
        String userName = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, userName, password);


        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
    }
}
