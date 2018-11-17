package br.com.projeto.modelo;


public class Produto extends Object{
	
	private Integer id_produto;
	private String nome_produto;
	private String descricao_produto;
	private double valor_produto;
	private Integer categoria_produto;
	private Integer empresa_produto;
	
	
	public Produto(Integer id_produto, String nome_produto, String descricao_produto, double valor_produto,
			Integer categoria_produto, Integer empresa_produto) {
		this.id_produto = id_produto;
		this.nome_produto = nome_produto;
		this.descricao_produto = descricao_produto;
		this.valor_produto = valor_produto;
		this.categoria_produto = categoria_produto;
		this.empresa_produto = empresa_produto;
	}
	
	public Produto(String nome_produto, String descricao_produto, double valor_produto,
			Integer categoria_produto, Integer empresa_produto) {
		this.nome_produto = nome_produto;
		this.descricao_produto = descricao_produto;
		this.valor_produto = valor_produto;
		this.categoria_produto = categoria_produto;
		this.empresa_produto = empresa_produto;
	}
	
	public Produto(Integer id_produto, String nome_produto, String descricao_produto, double valor_produto, Integer categoria_produto) {
		this.id_produto = id_produto;
		this.nome_produto = nome_produto;
		this.descricao_produto = descricao_produto;
		this.valor_produto = valor_produto;
		this.categoria_produto = categoria_produto;
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
	
	public Integer getCategoria_produto() {
		return categoria_produto;
	}
	
	public Integer getEmpresa_produto() {
		return empresa_produto;
	}
	
		

}
