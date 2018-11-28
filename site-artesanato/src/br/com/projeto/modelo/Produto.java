package br.com.projeto.modelo;

import java.util.List;

public class Produto extends Object{
	
	private Integer id_produto;
	private String nome_produto;
	private String descricao_produto;
	private double valor_produto;
	private Categoria categoria;
	private List<Imagem> lista_imagens;
	private Integer empresa_produto;
	
	
	public Produto(Integer id_produto, String nome_produto, String descricao_produto, double valor_produto,
			Categoria categoria,  List<Imagem> lista_imagens, Integer empresa_produto) {
		this.id_produto = id_produto;
		this.nome_produto = nome_produto;
		this.descricao_produto = descricao_produto;
		this.valor_produto = valor_produto;
		this.categoria = categoria;
		this.lista_imagens = lista_imagens;
		this.empresa_produto = empresa_produto;
	}
	
	public Produto(String nome_produto, String descricao_produto, double valor_produto,
			Categoria categoria, Integer empresa_produto) {
		this.nome_produto = nome_produto;
		this.descricao_produto = descricao_produto;
		this.valor_produto = valor_produto;
		this.categoria = categoria;
		this.empresa_produto = empresa_produto;
	}
	
	public Produto(Integer id_produto, String nome_produto, String descricao_produto, double valor_produto, Categoria categoria) {
		this.id_produto = id_produto;
		this.nome_produto = nome_produto;
		this.descricao_produto = descricao_produto;
		this.valor_produto = valor_produto;
		this.categoria = categoria;
	}

	public Integer getId_produto() {
		return id_produto;
	}
	
	public String getNome_produto() {
		return nome_produto;
	}


	public String getDescricao_produto() {
		return descricao_produto;
	}


	public double getValor_produto() {
		return valor_produto;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public Integer getEmpresa_produto() {
		return empresa_produto;
	}
	
	public List<Imagem> getLista_imagens() {
		return lista_imagens;
	}
	
	public void setLista_imagens(List<Imagem> lista_imagens) {
		this.lista_imagens = lista_imagens;
	}
		

}
