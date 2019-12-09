package sample;

import java.util.ArrayList;
import java.util.Iterator;

public class User_Manager {



    private ArrayList<User> userList = new ArrayList<User>();


    public void new_user(String username, String password, String type, String nome, String sobrenome, int cpf, int rg, String funcao) {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        myStmt = connection.preparedStatement("INSERT INTO USERS (nome, sobrenome, funcao, nascimento, cpf, rg, username, password, level) VALUES" +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        myStmt.setString(1, nome);
        myStmt.setString(2, sobrenome);
        myStmt.setString(3, funcao);
        myStmt.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
        myStmt.setInt(5, cpf);
        myStmt.setInt(6, rg);
        myStmt.setString(7, username);
        myStmt.setString(8, password);
        myStmt.setInt(9, level);

        myRs = myStmt.executeUpdate();

        display(myRs);
    }

    public void delete_user(String username) {

    }

    public void edit_user(String username, String password, String type, String nome, String sobrenome, int cpf, int rg, String funcao, int id) {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        myStmt = connection.preparedStatement("UPDATE USERS SET nome = ?, sobrenome = ?, funcao, nascimento = ?" +
                ", cpf = ?, rg = ?, username = ?, password = ?, level = ? WHERE id = ?");


        myStmt.setString(1, nome);
        myStmt.setString(2, sobrenome);
        myStmt.setString(3, funcao);
        myStmt.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
        myStmt.setInt(5, cpf);
        myStmt.setInt(6, rg);
        myStmt.setString(7, username);
        myStmt.setString(8, password);
        myStmt.setInt(9, level);
        myStmt.setInt(10, id);

        myRs = myStmt.executeUpdate();

        display(myRs);
    }

    public boolean search_user(int cpf) {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        myStmt = connection.preparedStatement("SELECT * FROM users WHERE cpf = ?");

        myStmt.setInt(1, cpf);

        myRs = myStmt.executeQuery();

        if (myRs){
            return true;
        }

        return false;
    }

    public User_Manager() {
        User user = new User("user", "user", 5);
        User adm = new User("admin", "admin", 4);
        userList.add(adm);
        userList.add(user);
    }

    public int authenticate(String name, String password) {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        myStmt = connection.preparedStatement("SELECT * FROM users WHERE username = ?");

        myStmt.setInt(1, username);

        myRs = myStmt.executeQuery();
        Iterator<User> itr = userList.iterator();

        while(itr.hasNext()){
            User aux = itr.next();
            if(aux.getNomeDeUsuario().equals(name)){
                if(aux.getSenha().equals(password)){
                    return aux.getAcesso();
                }
                else
                    return 3;
            }
        }
        return 2;
    }


}

