package sample;

public class Product {

    private int id;

    private String nome;

    private String setor;

    private float custo;

    private float preco;

    private int diaEntrada;

    private int mesEntrada;

    private int anoEntrada;

    private int diaSaida;

    private int mesSaida;

    private int anoSaida;

    private int quantidade;

    private boolean perecivel;

    private int diaValidade;

    private int mesValidade;

    private int anoValidade;

    private int fornecedor;

    private boolean defeituoso;

    private int lote;

    private String localizacao;

    private boolean Search_Product(int id){
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        private String sql = "SELECT * FROM users WHERE cpf=" + cpf + ";";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet){
            return true;
        }
        return false;
    }

    private void Add_Product(){
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        private String sql = "INSERT INTO PRODUCTS VALUES('" + nome + "','"+setor+"','"+custo+"','"+
                preco+"','"+diaEntrada+"','"+mesEntrada+"','"+anoEntrada+"','"+diaSaida+"','"+
                mesSaida+"','"+anoSaida+"','"+quantidade+"','"+perecivel+"','"+diaValidade+"','"+
                mesValidade+"','"+anoValidade+"','"+fornecedor+"','"+defeituoso+"','"+lote+"','"+localizacao+"');";
        Statement statement = connection.createStatement();
        rs = statement.executeQuery(sql);

    }
    private void Update_Product(String value, String field){
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        private String sql = "UPDATE PRODUCTS SET '" + field + "=" + value + " WHERE id=" + id +";";
        Statement statement = connection.createStatement();
        rs = statement.executeQuery(sql);

    }
}

