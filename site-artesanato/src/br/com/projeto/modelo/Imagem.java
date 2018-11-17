package br.com.projeto.modelo;

public class Imagem {
	
	private int id_img;
	private int id_produto;
	private String nome_img;
	
	public Imagem(int id_img, int id_produto, String nome_img) {
		this.id_img = id_img;
		this.id_produto = id_produto;
		this.nome_img = nome_img;
	}
	
	public int getId_img() {
		return id_img;
	}
	public int getId_produto() {
		return id_produto;
	}
	
	public String getNome_img() {
		return nome_img;
	}

	
}
