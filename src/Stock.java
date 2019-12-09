
import java.sql.*;
import Connectivity.ConnectionClass;
import java.util.ArrayList;
import java.util.Iterator;

public class Stock {
    public ConnectionClass connectionClass = new ConnectionClass();
    public Connection connection = connectionClass.getConnection();
    public PreparedStatement myStmt = null;
    public ResultSet myRs = null;

    ///private ArrayList<Product> productList = new ArrayList<Product>();

    //isso esta correto?
    //private StockControl stockControl;

    public Stock() {
        /***
        Product coca = new Product("B001", "Coca-Cola", 10, 2.50f);
        Product guarana = new Product("B002", "Guaraná", 10, 2.60f);
        Product arroz = new Product("B003", "Arroz 1KG", 10, 3.00f);
        Product feijao = new Product("B004", "Feijão 1KG", 10, 3.10f);
        Product tictac = new Product("B005", "Tic-Tac", 10, 1.50f);
        productList.add(coca);
        productList.add(guarana);
        productList.add(feijao);
        productList.add(arroz);
        productList.add(tictac);
         */
    }

    public void new_product(String name, int code, int initial_qty, int custo, int preco, boolean perecivel, String fornecedor, String lote, String localizacao) throws SQLException {
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        myStmt = connection.prepareStatement("INSERT INTO produtos (nome, code, quantidade, custo, preco, " +
                "dataentrada, perecivel, fornecedor, lote, localizacao, dataValidade) VALUES (? ,? ,? ,? ,?, ?, ?, ?, ?, ?, ?)");

        myStmt.setString(1, name);
        myStmt.setInt(2, code);
        myStmt.setInt(3, initial_qty);
        myStmt.setInt(4, custo);
        myStmt.setInt(5, preco);
        myStmt.setDate(6, java.sql.Date.valueOf(java.time.LocalDate.now()));
        myStmt.setBoolean(7, perecivel);
        myStmt.setString(8, fornecedor);
        myStmt.setString(9, lote);
        myStmt.setString(10, localizacao);
        myStmt.setDate(11, java.sql.Date.valueOf(java.time.LocalDate.now()));

        myStmt.executeUpdate();
    }

    public void update_qty(String product,  int new_qty) throws SQLException {

         myStmt = connection.prepareStatement("UPDATE produtos SET quantidade = ? WHERE id = ?");

         myStmt.setInt(1, new_qty);
         myStmt.setInt(2, Integer.parseInt(product));
         myStmt.executeUpdate();

        /**
        Iterator<Product> itr = productList.iterator();

        while(itr.hasNext()) {
            Product aux = itr.next();
            if (aux.getID().equals(product)) {
                aux.setQuantidadeAux(aux.getQuantidade() - _qty);
                if(aux.getQuantidadeAux() >= 0){
                    aux.setQuantidade(aux.getQuantidadeAux());
                }
                return aux;
            }
        }
        return null;
         */
    }

    public boolean search(int codigo) throws SQLException {

        myStmt = connection.prepareStatement("SELECT * FROM produtos WHERE cpf = ?");

        myStmt.setInt(1, codigo);

        myRs = myStmt.executeQuery();

        if (myRs.next()){
            return true;
        }

        final boolean b = false;
        return b;
    }

    public void log_report() {

    }

}

