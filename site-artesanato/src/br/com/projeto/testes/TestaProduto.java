package br.com.projeto.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.projeto.jdbc.Conexao;
import br.com.projeto.jdbc.dao.ProdutoDAO;
import br.com.projeto.modelo.Produto;

public class TestaProduto {

	public static void main(String[] args) throws SQLException {
//		list();
//		select(1);
//		update(1, "Pano de prato de galinha", 10.0, "Pano com bordado de uma galinha", 1);
		insert("TESTE", "TESTE", 10.0, 1, 1);
//		delete(2);
//		list();

	}
	
	/**
	 * Teste de listagem de produtos
	 * 
	 */
	public static void list() throws SQLException {
		try (Connection con = new Conexao().getConnection()) {

			System.out.println("Teste de lista de produtos");
			List<Produto> lista = new ProdutoDAO(con).list();
			for (Produto produto : lista) {
				System.out.println(produto.getId_produto() + " - " + produto.getNome_produto() + " - " + produto.getValor_produto());
			}
		}
	}
	
	/**
	 * Teste de seleção de um produto.
	 * 
	 * @param id_produto
	 * @throws SQLException
	 */
	private static void select(int id_produto) throws SQLException {
		try(Connection con = new Conexao().getConnection()){
			ProdutoDAO buscaProduto = new ProdutoDAO(con);
			Produto item = buscaProduto.select(id_produto);
			System.out.println("Teste de seleção de um produto");
			System.out.println(item.getId_produto() +" - "+ item.getNome_produto());
		}
		
	}
	
	/**
	 * Teste de alteração de um  produto.
	 * @param id
	 * @param nome
	 * @param valor
	 * @param descricao
	 * @param categoria
	 * @throws SQLException
	 */
	private static void update(int id, String nome, double valor, String descricao, int categoria) throws SQLException {
		try(Connection con = new Conexao().getConnection()){
			Produto produto = new Produto(id, nome, descricao, valor, categoria);
			ProdutoDAO update = new ProdutoDAO(con);
			update.update(produto);
			System.out.println("Teste de edição de um produto");
			System.out.println("Produto atualizado");
			select(id);
		}
		
	}
	
	/**
	 * Teste de inserção de um novo produto.
	 * @param nome
	 * @param descricao
	 * @param valor
	 * @param categoria
	 * @param empresa
	 * @throws SQLException
	 */
	public static void insert(String nome, String descricao, double valor, int categoria, int empresa) throws SQLException {
		try (Connection con = new Conexao().getConnection()) {
			Produto novoProduto = new Produto(nome, descricao, valor, categoria, empresa);
			ProdutoDAO dao = new ProdutoDAO(con);
			dao.insert(novoProduto);

			System.out.println("cadastro realizado com sucesso");
		}
	}
	
	/**
	 * Teste de remoção de um produto existente.
	 * 
	 * @param id_produto
	 * @throws SQLException
	 */
	private static void delete(int id_produto) throws SQLException {
		try(Connection con = new Conexao().getConnection()){
			ProdutoDAO removeProduto = new ProdutoDAO(con);
			removeProduto.delete(id_produto);
		}
	}
		

}
