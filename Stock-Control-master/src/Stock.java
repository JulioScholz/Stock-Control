package sample;

import java.util.ArrayList;

public class Stock {


    private ArrayList<Product> productList;
    private int codigo;
    //isso esta correto?
    //private StockControl stockControl;


    private Product[] product;

    public Stock(int codigo) {

        this.codigo = codigo;
    }

    public void new_product(String name, int code, int initial_qty, double  custo, double preco, boolean perecivel, String Fornecedor, String lote, String localizacao) {

        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        myStmt = connection.preparedStatement("INSERT INTO PRODUCTS (nome, code, quantidade, custo, preco, " +
                "dataentrada, perecivel, fornecedor, lote, localizacao, dataValidade) VALUES (? ,? ,? ,? ,?, ?, ?, ?, ?, ?, ?)");

        myStmt.setString(1, name);
        myStmt.setInt(2, code);
        myStmt.setInt(3, initial_qty);
        myStmt.setDouble(4, custo);
        myStmt.setDouble(5, preco);
        myStmt.setDate(6, java.sql.Date.valueOf(java.time.LocalDate.now()));
        myStmt.setBoolean(7, perecivel);
        myStmt.setString(8, fornecedor);
        myStmt.setString(9, lote);
        myStmt.setString(10, localizacao);
        myStmt.setDate(11, java.sql.Date.valueOf(java.time.LocalDate.now()));

        myRs = myStmt.executeUpdate();

        display(myRs);

    }

    public void update_qty(int product,  int new_qty) {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        myStmt = connection.preparedStatement("UPDATE PRODUCTS SET quantidade = ? WHERE id = ?");

        myStmt.setInt(1, new_qty);
        myStmt.setInt(2, product);
        myRs = myStmt.executeUpdate();
    }

    public boolean search() {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        private String sql = "SELECT * FROM products WHERE cpf=" + cpf + ";";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet){
            return true;
        }
        return false;
    }

    public void log_report() {

    }

}

