package br.com.projeto.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.projeto.jdbc.Conexao;
import br.com.projeto.jdbc.dao.CategoriaDAO;
import br.com.projeto.modelo.Categoria;

public class TestaCategoria {

	public static void main(String[] args) throws SQLException {

//		insert("uadros");
//		delete(5);
//		list();
//		select(1);
//		update(2,"Tric�");
		testaConexao();
		

	}
	
	/**
	 * Testa conex�o com o servidor-BD
	 * @throws SQLException
	 */
	private static void testaConexao() throws SQLException {
		try(Connection con = new Conexao().getConnection()){
			System.out.println("conex�o realizada com sucesso");
		}
	}

	/**
	 * Teste de edi��o de uma categoria
	 * @param id_categoria
	 * @param novoNome
	 * @throws SQLException
	 */
	@SuppressWarnings("unused")
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
	 * Teste de selec�o de uma categoria
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
	 * Teste de remo��o categoria
	 * @param id_categoria
	 * @throws SQLException
	 */
	@SuppressWarnings("unused")
	private static void delete(int id_categoria) throws SQLException {
		try(Connection con = new Conexao().getConnection()){
			CategoriaDAO removeCategoria = new CategoriaDAO(con);
			removeCategoria.delete(id_categoria);
		}
		
	}
	
	/**
	 * Teste de inser��o categoria
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