package sample;

public class User {

    protected String id;

    protected String nome;

    protected String sobrenome;

    protected String funcao;

    protected int diaNasc;

    protected int mesNasc;

    protected int anoNasc;

    protected int cpf;

    protected int rg;

    protected String nomeDeUsuario;

    protected String senha;

    protected int acesso;

    private Stock stock;

    private User_Manager users;

    public User(String name, Stock stock) {

    }

    public User(String usuario, String _senha, int _acesso) {
        nomeDeUsuario = usuario;
        senha = _senha;
        acesso = _acesso;
    }

    public String getNomeDeUsuario(){
        return nomeDeUsuario;
    }
    public String getSenha(){
        return senha;
    }
    public int getAcesso(){
        return acesso;
    }

    public boolean login(String name, String password) {
        return false;
    }

    public void logout() {

    }

    public boolean sell() {
        return false;
    }

    public boolean restock(int prod_code) {
        return false;
    }

}
