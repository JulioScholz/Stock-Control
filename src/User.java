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

    public User() {

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
