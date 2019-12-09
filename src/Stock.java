package sample;

import java.util.ArrayList;
import java.util.Iterator;

public class Stock {

    private ArrayList<Product> productList = new ArrayList<Product>();

    //isso esta correto?
    //private StockControl stockControl;

    public Stock() {
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
    }

    public void new_product(String name, int code, int initial_qty) {
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

    public Product update_qty(String product,  int _qty) {
        /***
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        myStmt = connection.preparedStatement("UPDATE PRODUCTS SET quantidade = ? WHERE id = ?");

        myStmt.setInt(1, new_qty);
        myStmt.setInt(2, product);
        myRs = myStmt.executeUpdate();
        
        
        
        */
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

