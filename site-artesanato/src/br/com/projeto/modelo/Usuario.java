package br.com.projeto.modelo;

public class Usuario {

	private int id;
	private String nome;
	private String email;
	private String senha;
	private int perfil;
	
	public Usuario(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
	
	public int getPerfil() {
		return perfil;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this.email == ((Usuario)o).getEmail() && this.senha == ((Usuario)o).getSenha()) {
			return true;
		} else {
			return false;
		}
		
	}
	
	

}
