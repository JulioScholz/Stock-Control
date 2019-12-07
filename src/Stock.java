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

    }

    public Product update_qty(String product,  int _qty) {
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
        return false;
    }

    public void log_report() {

    }

}

