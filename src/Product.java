package sample;

public class Product {

    private String id;

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
    private int quantidadeAux;

    private boolean perecivel;

    private int diaValidade;

    private int mesValidade;

    private int anoValidade;

    private int fornecedor;

    private boolean defeituoso;

    private int lote;

    private String localizacao;



    public String getID(){
        return id;
    }
    public String getNome(){
        return nome;
    }
    public int getQuantidade(){
        return quantidade;
    }
    public float getPreco(){
        return preco;
    }
    public void setQuantidadeAux(int quantidade){
        quantidadeAux = quantidade;
    }
    public int getQuantidadeAux(){
        return quantidadeAux;
    }
    public void setQuantidade(int _quantidade){
        quantidade = _quantidade;
    }
    public Product(String _ID, String _nome, int _quantidade, float _preco){
        id = _ID;
        nome = _nome;
        quantidade = _quantidade;
        preco = _preco;
    }

}

