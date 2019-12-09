package Connectivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Search_BD {
    public Search_BD(){
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
    }
    public boolean SearchUser(int cpf){
        String sql = "SELECT * FROM users WHERE cpf=" + cpf + ";";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet){
            return true;
        }
        return false;
    }
}

Search_BD search_bd = new Search_BD(0);
System.out.print(search_bd);