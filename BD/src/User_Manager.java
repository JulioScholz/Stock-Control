import Connectivity.ConnectionClass;

import java.sql.*;

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

        public void delete_user(String username) {

        }
        public void edit_user(String username, String password, int tipo, String nome, String sobrenome, int cpf, int rg, String funcao, int id) throws SQLException {
            ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            PreparedStatement myStmt = null;
            ResultSet myRs = null;

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
            ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            PreparedStatement myStmt = null;
            ResultSet myRs = null;

            myStmt = connection.prepareStatement("SELECT * FROM users WHERE cpf = ?");

            myStmt.setInt(1, cpf);

            myRs = myStmt.executeQuery();

            if (myRs.next() != false){
                return true;
            }

            return false;
        }
        public int authenticate(String user_name, String password) throws SQLException {
            int resposta = 0;
            myStmt = connection.prepareStatement("SELECT * From users WHERE user_name = ? AND password = ?");
            myStmt.setString(1, user_name);
            myStmt.setString(2, password);
            try {
                myRs = myStmt.executeQuery();
                while ( myRs.next() ){
                    resposta = myRs.getInt ("nivel_acesso");
                }

            } catch (Exception e){
                e.printStackTrace();
            }
            myRs.close();
            myStmt.close();
            connection.close();
            return resposta;
        }


}



