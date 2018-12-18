package br.com.projeto.modelo;

public class Categoria {

	private Integer id_categoria;
	private String nome_categoria;
	
	

	public Categoria(Integer id_categoria, String nome_categoria) {
		super();
		this.id_categoria = id_categoria;
		this.nome_categoria = nome_categoria;
	}
	
	public Categoria(Integer id_categoria) {
		super();
		this.id_categoria = id_categoria;
	}

	public Integer getId_categoria() {
		return id_categoria;
	}
	
	public String getNome_categoria() {
		return nome_categoria;
	}
	
	public static boolean valida(String nome){
		if(nome.matches("[A-Z][a-z]{2,}")){
			return true;
		}
		return false;
	}
	
	
	
}
