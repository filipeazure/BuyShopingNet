package br.com.BuyShoppingNet.VO;

public class Pessoa {
	private String Login;
	private String Nome;
	private String Senha;
	private String ConfirmaSenha;
	private String Email;
	private String ConfirmaEmail;
	private String Cpf;
	private String ConfirmaCPF;

	public Pessoa() {
		super();

	}

	public Pessoa(String login, String nome, String senha,
			String confirmaSenha, String email, String confirmaEmail,
			String cpf, String confirmaCPF) {
		super();
		Login = login;
		Nome = nome;
		Senha = senha;
		ConfirmaSenha = confirmaSenha;
		Email = email;
		ConfirmaEmail = confirmaEmail;
		Cpf = cpf;
		ConfirmaCPF = confirmaCPF;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public String getConfirmaSenha() {
		return ConfirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		ConfirmaSenha = confirmaSenha;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getConfirmaEmail() {
		return ConfirmaEmail;
	}

	public void setConfirmaEmail(String confirmaEmail) {
		ConfirmaEmail = confirmaEmail;
	}

	public String getCpf() {
		return Cpf;
	}

	public void setCpf(String cpf) {
		Cpf = cpf;
	}

	public String getConfirmaCPF() {
		return ConfirmaCPF;
	}

	public void setConfirmaCPF(String confirmaCPF) {
		ConfirmaCPF = confirmaCPF;
	}

}
