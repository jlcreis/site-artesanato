package br.com.projeto.testes;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.projeto.app.ConstantesApp;
import br.com.projeto.jdbc.Conexao;
import br.com.projeto.jdbc.dao.ImagemDAO;
import br.com.projeto.modelo.Imagem;

public class TestaImagem {

	public static void main(String[] args) throws SQLException {


	}
	
	public static void insert(int id, String nome) throws SQLException {
		try (Connection con = new Conexao().getConnection()) {
			ImagemDAO dao = new ImagemDAO(con);
			dao.insert(id, nome);

			System.out.println("cadastro realizado com sucesso");
		}
	}
	
	public static void list(int id) throws SQLException {
		try (Connection con = new Conexao().getConnection()) {
			//new InicializaApp();
			List<Imagem> lista = new ImagemDAO(con).lista(id);
			for (Imagem imagem : lista) {

				System.out.println(imagem.getId_img() + " - " + imagem.getNome_img() + " - " + imagem.getId_produto());
				System.out.println(ConstantesApp.CAMINHO_IMG + imagem.getNome_img() + ".jpg");
			}
		}
	}

	@SuppressWarnings("unused")
	private static void delete(int id) throws SQLException {
		try(Connection con = new Conexao().getConnection()){
			ImagemDAO removeImagem = new ImagemDAO(con);
			removeImagem.delete(id);
		}
		
	}

}
