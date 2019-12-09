package Connectivity;

import java.sql.Connection;

public class ConnectionClass {
    public Connection getConnection(){

        String dbName="stockmarket";
        String userName="root";
        String password="";

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,password);


        } catch (Exception e) {
            e.printStackTrace();
        }


        return connection;
}
