package br.com.projeto.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projeto.modelo.Imagem;

public class ImagemDAO {

	private final Connection con;

	public ImagemDAO(Connection con) {
		this.con = con;
	}

	/**
	 * Insere registro no bd de uma nova imagem.
	 * @param id_produto
	 * @param nome
	 * @throws SQLException
	 */
	public void insert(int id_produto, String nome) throws SQLException {

		String query = "insert into img_produto (id_produto, nome_img) value (?, ?)";

		try (PreparedStatement pstmt = con.prepareStatement(query)) {

			pstmt.setInt(1, id_produto);
			pstmt.setString(2, nome);
			pstmt.execute();

		}
	}
	
	/**
	 * Lista imagens existentes de um produto.
	 * @return
	 * @throws SQLException
	 */
	public List<Imagem> lista(int id_produto) throws SQLException {
		List<Imagem> imagens = new ArrayList<>();

		String query = "select * from img_produto where id_produto = ?";

		try (PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setInt(1, id_produto);
			pstmt.execute();
			try (ResultSet rs = pstmt.getResultSet()) {
				while (rs.next()) {
					int id_img = rs.getInt("id_img");
					String nome = rs.getString("nome_img");
					Imagem img = new Imagem(id_img, id_produto, nome);
					imagens.add(img);
				}
			}
		}
		return imagens;
	}
	
	/**
	 * Remove registro de imagem do banco de dados;
	 * 
	 * @param id
	 */
	public void delete(int id) {
		try {
			String query = "delete from img_produto where id_img = ?";

			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.execute();

		} catch (Exception e) {
			System.err.println("Ocorreu um erro!");
			System.err.println(e.getMessage());
		}
	}

}
