package br.com.projeto.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projeto.modelo.Categoria;

public class CategoriaDAO {

	private final Connection con;

	/**
	 * Método construtor
	 * @param con
	 */
	public CategoriaDAO(Connection con) {
		this.con = con;
	}

	/**
	 * Método de inserção de uma nova categoria.
	 * 
	 * @param nome_categoria
	 * @throws SQLException
	 */
	public void insert(String nome_categoria) throws SQLException {
		try {
			String query = "insert into categorias (nome_categoria) value (?)";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, nome_categoria);
			pstmt.execute();

		} catch (Exception e) {
			System.err.println("Ocorreu um erro!");
			System.err.println(e.getMessage());

		}
	}

	/**
	 * Método de listagem de categorias existentes.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Categoria> lista() throws SQLException {
		List<Categoria> categorias = new ArrayList<>();

		String query = "select * from categorias order by nome_categoria";

		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.execute();
			try (ResultSet rs = pstmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("id_categoria");
					String nome = rs.getString("nome_categoria");
					Categoria categoria = new Categoria(id, nome);
					categorias.add(categoria);
				}
			}
		}
		return categorias;
	}

	/**
	 * Método de exclusão de uma categoria existente.
	 * 
	 * @param id_categoria
	 * @throws SQLException 
	 */
	public void delete(int id_categoria) throws SQLException {
//		try {
			String query = "delete from categorias where id_categoria = ?";

		try(PreparedStatement pstmt = con.prepareStatement(query)){
			pstmt.setInt(1, id_categoria);
			pstmt.execute();
		}
//		} catch (Exception e) {
//			System.err.println("Ocorreu um erro!");
//			System.err.println(e.getMessage());
//		}
	}

	/**
	 * Método de seleção de uma categoria.
	 * 
	 * @param id_categoria
	 * @return
	 * @throws SQLException
	 */
	public Categoria select(int id_categoria) throws SQLException {
		Categoria categoria = null;
		String query = "select * from categorias where id_categoria = ?";
		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setInt(1, id_categoria);
			pstmt.execute();
			try (ResultSet rs = pstmt.getResultSet()) {
				while (rs.next()) {
					int id = rs.getInt("id_categoria");
					String nome = rs.getString("nome_categoria");
					Categoria resultado = new Categoria(id, nome);
					categoria = resultado;
				}
			}
		}
		
		return categoria;
	}
	
	/**
	 * Método de edição de uma categoria existente.
	 * @param categoria
	 * @throws SQLException
	 */
	public void update(Categoria categoria) throws SQLException {
		String query = "UPDATE categorias SET nome_categoria = ? WHERE id_categoria = ?";
		try(PreparedStatement pstmt = con.prepareStatement(query)){
			pstmt.setString(1, categoria.getNome_categoria());
			pstmt.setInt(2, categoria.getId_categoria());
			pstmt.execute();
		}
	}
}
