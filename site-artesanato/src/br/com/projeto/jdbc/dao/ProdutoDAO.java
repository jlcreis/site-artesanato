package br.com.projeto.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.projeto.modelo.Categoria;
import br.com.projeto.modelo.Produto;

public class ProdutoDAO {

	private final Connection con;
	
	/**
	 * Método construtor
	 * @param con
	 */
	public ProdutoDAO(Connection con) {
		this.con = con;
	}
	
	/**
	 * Método de listagem de produtos existentes.
	 * @return
	 * @throws SQLException
	 */
	public List<Produto> list() throws SQLException {
		List<Produto> produtos = new ArrayList<>();

		String query = "select * from produtos p join categorias c where p.categoria_produto = c.id_categoria order by nome_produto";

		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.execute();
			try (ResultSet rs = pstmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("id_produto");
					String nome = rs.getString("nome_produto");
					String descricao = rs.getString("descricao_produto");
					double valor = rs.getDouble("valor_produto");
					int id_categoria = rs.getInt("id_categoria");
					String nome_categoria = rs.getString("nome_categoria");
					Categoria categoria = new Categoria (id_categoria,nome_categoria);
					Produto produto = new Produto(id, nome, descricao, valor, categoria);
					produtos.add(produto);
				}
			}
		}
		return produtos;
	}
	
	/**
	 * Lista os 5 ultimos produtos cadastrados.
	 * @return
	 * @throws SQLException
	 */
	public List<Produto> top5() throws SQLException {
		List<Produto> produtos = new ArrayList<>();

		String query = "select * from produtos p join categorias c where p.categoria_produto = c.id_categoria order by p.id_produto desc LIMIT 5";

		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.execute();
			try (ResultSet rs = pstmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("id_produto");
					String nome = rs.getString("nome_produto");
					String descricao = rs.getString("descricao_produto");
					double valor = rs.getDouble("valor_produto");
					int id_categoria = rs.getInt("id_categoria");
					String nome_categoria = rs.getString("nome_categoria");
					Categoria categoria = new Categoria (id_categoria,nome_categoria);
					Produto produto = new Produto(id, nome, descricao, valor, categoria);
					produtos.add(produto);
				}
			}
		}
		return produtos;
	}
	
	/**
	 * Lista todos os produtos de uma determinada categoria.
	 * @param categoria
	 * @return
	 * @throws SQLException
	 */
	public List<Produto> produtoCategoria(int categoria) throws SQLException{
		List<Produto> produtos = new ArrayList<>();

		String query = "select * from produtos p join categorias c where p.categoria_produto = ? and p.categoria_produto = c.id_categoria order by p.nome_produto";

		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setInt(1, categoria);
			pstmt.execute();
			try (ResultSet rs = pstmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("id_produto");
					String nome = rs.getString("nome_produto");
					String descricao = rs.getString("descricao_produto");
					double valor = rs.getDouble("valor_produto");
					int id_categoria = rs.getInt("id_categoria");
					String nome_categoria = rs.getString("nome_categoria");
					Categoria c = new Categoria (id_categoria,nome_categoria);
					Produto produto = new Produto(id, nome, descricao, valor, c);
					produtos.add(produto);
				}
			}
		}
		return produtos;
	}
	
	/**
	 * Método para seleção de um produto existente.
	 * 
	 * @param id_produto
	 * @return
	 * @throws SQLException
	 */
	public Produto select(int id_produto) throws SQLException {
		Produto produto = null;
		String query = "select * from produtos p join categorias c where p.categoria_produto = c.id_categoria and p.id_produto = ?";
		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setInt(1, id_produto);
			pstmt.execute();
			try (ResultSet rs = pstmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("id_produto");
					String nome = rs.getString("nome_produto");
					String descricao = rs.getString("descricao_produto");
					double valor = rs.getDouble("valor_produto");
					int id_categoria = rs.getInt("id_categoria");
					String nome_categoria = rs.getString("nome_categoria");
					Categoria categoria = new Categoria (id_categoria,nome_categoria);
					Produto resultado = new Produto(id, nome, descricao, valor, categoria);
					produto = resultado;
				}
			}
		}
		
		return produto;
	}
	
	/**
	 * Método para edição de um produto existente.
	 * 
	 * @param produto
	 * @throws SQLException
	 */
	
	public void update(Produto produto) throws SQLException {
		String query = "UPDATE produtos SET nome_produto = ?, descricao_produto = ?, valor_produto = ?, categoria_produto = ? WHERE id_produto = ?";
		try(PreparedStatement pstmt = con.prepareStatement(query)){
			pstmt.setString(1, produto.getNome_produto());
			pstmt.setString(2, produto.getDescricao_produto());
			pstmt.setDouble(3, produto.getValor_produto());
			pstmt.setInt(4, produto.getCategoria().getId_categoria());
			pstmt.setInt(5, produto.getId_produto());
			pstmt.execute();
		}
	}
	
	/**
	 * Método de inserção de um novo produto.
	 * @param produto
	 * @throws SQLException
	 */
	public int insert(Produto produto) throws SQLException {
		try {
			String query = "insert into produtos (nome_produto, descricao_produto, valor_produto, categoria_produto, empresa_produto) value (?,?,?,?,?)";
			int key = 0;
			
			PreparedStatement pstmt = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, produto.getNome_produto());
			pstmt.setString(2, produto.getDescricao_produto());
			pstmt.setDouble(3, produto.getValor_produto());
			pstmt.setInt(4, produto.getCategoria().getId_categoria());
			pstmt.setInt(5, produto.getEmpresa_produto());
			pstmt.execute();
			ResultSet resultSet =pstmt.getGeneratedKeys();
			while (resultSet.next()) {
				key = resultSet.getInt(1);
			}
			resultSet.close();
			
			return key;

		} catch (Exception e) {
			System.err.println("Ocorreu um erro!");
			System.err.println(e.getMessage());

		}
		
		return 0;
	}
	
	/**
	 * Método de remoção de um produto.
	 * 
	 * @param id
	 */
	public void delete(int id) {
		try {
			String query = "delete from produtos where id_produto = ?";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.execute();

		} catch (Exception e) {
			System.err.println("Ocorreu um erro!");
			System.err.println(e.getMessage());
		}
	}

}
