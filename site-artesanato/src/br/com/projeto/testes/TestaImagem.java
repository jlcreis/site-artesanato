package br.com.projeto.testes;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.lang.model.element.ModuleElement.RequiresDirective;

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
//		redimencionaImg();
		System.out.println(testaScala(400, 800));
		System.out.println(testaScala(800, 800));
		System.out.println(testaScala(1280, 600));
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
	private static void delete(int id, String nomeImagem) throws SQLException {
		try(Connection con = new Conexao().getConnection()){
			ImagemDAO removeImagem = new ImagemDAO(con);
			removeImagem.delete(id, nomeImagem);
		}
		
	}

	private static void redimencionaImg() throws IOException {
		BufferedImage imagem = null;
		try {
			imagem = ImageIO.read(new File ("D:/Projeto Empresa/site artesanato/Imagens/VendasMercadoLivre/Toalha de Rosto/IMG-20160902-WA0009.jpg"));
		} catch (IOException ex) {
			System.out.println("Erro: "+ ex.getMessage());
		}
		int  new_w = (int) (imagem.getWidth() * 0.2), new_h = (int) (imagem.getHeight() * 0.2);
		BufferedImage new_img = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = new_img.createGraphics();
		g.drawImage(imagem,	0, 0, new_w, new_h, null);
		ImageIO.write(new_img, "jpg", new File("D:/Projeto Empresa/site artesanato/Imagens/VendasMercadoLivre/Toalha de Rosto/tb1_IMG-20160902-WA0009.jpg"));
	}
	
	private static String testaScala(int new_w, int new_h) {
		
		double percent_w = (double)200/new_w;
		double percent_h = (double)200/new_h;
		
		if (percent_w > percent_h) {
			new_w = (int) (new_w * percent_w);
			new_h = (int) (new_h * percent_w);
		} else {
			new_w = (int) (new_w * percent_h);
			new_h = (int) (new_h * percent_h);
		}

		return "w: "+ new_w + ", h: "+ new_h;
		
	}
}
