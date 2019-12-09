
import java.util.ArrayList;
import java.util.Iterator;
import java.sql.*;
import Connectivity.ConnectionClass;

public class User_Manager {

    public ConnectionClass connectionClass = new ConnectionClass();
    public Connection connection = connectionClass.getConnection();
    public PreparedStatement myStmt = null;
    public ResultSet myRs = null;

    public void new_user(String username, String password, int tipo, String nome, String sobrenome, int cpf, int rg, String funcao) throws SQLException {

        myStmt = connection.prepareStatement("INSERT INTO USERS (nome, sobrenome, funcao, nascimento, cpf, rg, user_name, password, nivel_acesso) VALUES" +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?)");
        myStmt.setString(1, nome);
        myStmt.setString(2, sobrenome);
        myStmt.setString(3, funcao);
        myStmt.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
        myStmt.setInt(5, cpf);
        myStmt.setInt(6, rg);
        myStmt.setString(7, username);
        myStmt.setString(8, password);
        myStmt.setInt(9, tipo);

        myStmt.executeUpdate();

    }

    public void delete_user(int cpf) throws SQLException {
        myStmt = connection.prepareStatement("DELETE FROM USER WHERE CPF = ?");
        myStmt.setInt(1, cpf);

        myStmt.executeUpdate();
    }
    public void edit_user(String username, String password, int tipo, String nome, String sobrenome, int cpf, int rg, String funcao, int id) throws SQLException {
        myStmt = connection.prepareStatement("UPDATE USERS SET nome = ?, sobrenome = ?, funcao, nascimento = ?" +
                ", cpf = ?, rg = ?, username = ?, password = ?, level = ? WHERE id = ?");


        myStmt.setString(1, nome);
        myStmt.setString(2, sobrenome);
        myStmt.setString(3, funcao);
        myStmt.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
        myStmt.setInt(5, cpf);
        myStmt.setInt(6, rg);
        myStmt.setString(7, username);
        myStmt.setString(8, password);
        myStmt.setInt(9, tipo);
        myStmt.setInt(10, id);

        myStmt.executeUpdate();
    }

    public boolean search_user(int cpf) throws SQLException {
        myStmt = connection.prepareStatement("SELECT * FROM users WHERE cpf = ?");

        myStmt.setInt(1, cpf);

        myRs = myStmt.executeQuery();

        if (myRs.next()){
            return true;
        }

        final boolean b = false;
        return b;
    }

    public boolean authenticate(String user_name, String password) throws SQLException {

        myStmt = connection.prepareStatement("SELECT * user WHERE (user_name = ?, password = ?");

        myStmt.setString(1, user_name);
        myStmt.setString(2, password);

        myRs = myStmt.executeQuery();

        if (myRs.next()){
            return true;
        }

        final boolean b = false;
        return b;
        /**
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
         */
    }

}

