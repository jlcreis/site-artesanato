package br.com.projeto.testes;

import java.io.IOException;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileItem;

import br.com.projeto.app.ConstantesApp;
import br.com.projeto.jdbc.Conexao;
import br.com.projeto.jdbc.dao.ImagemDAO;
import br.com.projeto.modelo.Imagem;

public class TestaImagem {

	public static void main(String[] args) throws SQLException, SocketException, IOException {

//		String nomeImg = "IMG-20160902-WA0009.jpg";
//		
//		InputStream arqEnviar = new FileInputStream("D:/Projeto Empresa/site artesanato/Imagens/VendasMercadoLivre/Toalha de Rosto/"+nomeImg);
		
//		upload(nomeImg, arqEnviar);
	}
	
	public static void upload(String nome, FileItem arqEnviar) throws Exception {
		try (Connection con = new Conexao().getConnection()) {
			ImagemDAO dao = new ImagemDAO(con);
			dao.upload(nome, arqEnviar);

			System.out.println("cadastro realizado com sucesso");
		}
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
