package model;

public class Utente {
	
	private String nome;
	private String username;
	private String psw;
	
	public Utente(String nome, String username, String psw) {
		this.nome = nome;
		this.username = username;
		this.psw = psw;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", username=" + username + ", psw=" + psw + "]";
	}
	
}
