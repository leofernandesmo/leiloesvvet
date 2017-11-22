package br.org.leofernandesmo.leiloesvvet.model;

public class Usuario {
	private String nome;
	private String email;
	
	public Usuario() {
		super();
	}

	public Usuario(String nome) {
		super();
		this.nome = nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
