package br.com.projeto.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.projeto.jdbc.Conexao;
import br.com.projeto.jdbc.dao.CategoriaDAO;
import br.com.projeto.modelo.Categoria;

public class TestaCategoria {

	public static void main(String[] args) throws SQLException {

		insert("Quadros");
		delete(5);
		list();
		select(1);
		update(2,"Tricô");

	}

	/**
	 * Teste de edição de uma categoria
	 * @param id_categoria
	 * @param novoNome
	 * @throws SQLException
	 */
	private static void update(int id_categoria, String novoNome) throws SQLException {
		try(Connection con = new Conexao().getConnection()){
			Categoria categoria = new Categoria(id_categoria, novoNome);
			CategoriaDAO update = new CategoriaDAO(con);
			update.update(categoria);
			System.out.println("Categoria atualizada");
			select(id_categoria);
		}
		
	}

	/**
	 * Teste de selecão de uma categoria
	 * @param id_categoria
	 * @throws SQLException
	 */
	private static void select(int id_categoria) throws SQLException {
		try(Connection con = new Conexao().getConnection()){
			CategoriaDAO buscaCategoria = new CategoriaDAO(con);
			Categoria item = buscaCategoria.select(id_categoria);
			System.out.println(item.getId_categoria() +" - "+ item.getNome_categoria());
		}
		
	}

	/**
	 * Teste de remoção categoria
	 * @param id_categoria
	 * @throws SQLException
	 */
	private static void delete(int id_categoria) throws SQLException {
		try(Connection con = new Conexao().getConnection()){
			CategoriaDAO removeCategoria = new CategoriaDAO(con);
			removeCategoria.delete(id_categoria);
		}
		
	}
	
	/**
	 * Teste de inserção categoria
	 * @param nomeCategoria
	 * @throws SQLException
	 */
	public static void insert(String nomeCategoria) throws SQLException {
		try (Connection con = new Conexao().getConnection()) {
			CategoriaDAO novaCategoria = new CategoriaDAO(con);
			novaCategoria.insert(nomeCategoria);

			System.out.println("cadastro realizado com sucesso");
		}
	}

	
	/**
	 * Teste de listar categorias
	 * @throws SQLException
	 */
	public static void list() throws SQLException {
		try (Connection con = new Conexao().getConnection()) {

			List<Categoria> lista = new CategoriaDAO(con).lista();
			for (Categoria categoria : lista) {
				System.out.println(categoria.getId_categoria() + " - " + categoria.getNome_categoria());
			}
		}
	}

}