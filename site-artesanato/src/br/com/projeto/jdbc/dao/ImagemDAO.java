package br.com.projeto.jdbc.dao;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.tomcat.util.http.fileupload.FileItem;

import br.com.projeto.app.ConstantesApp;
import br.com.projeto.jdbc.ConexaoFTP;
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
		System.out.println("dentro do insert");
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
	 * Lista a primeira imagem de um produto.
	 * @param id_produto
	 * @return
	 * @throws SQLException
	 */
	public List<Imagem> imgTop(int id_produto) throws SQLException {
		List<Imagem> imagens = new ArrayList<>();

		String query = "select * from img_produto where id_produto = ? LIMIT 1";

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
	 * Remove registro de imagem do banco de dados.
	 * @param id
	 */
	public void delete(int id, String nomeImg) {
		try {
			String query = "delete from img_produto where id_img = ?";
		
			//deleta arquivo da pasta
			FTPClient ftp = new ConexaoFTP().getFtp();
			deletaArquivo(nomeImg, ftp);
			ftp.logout();
			ftp.disconnect();
			
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.execute();

		} catch (Exception e) {
			System.err.println("Ocorreu um erro!");
			System.err.println(e.getMessage());
		}
	}
	
	/**
	 * Remove todos os registro de imagens de um produto deletado.
	 * @param id_produto
	 * @throws SQLException
	 * @throws IOException 
	 * @throws SocketException 
	 */
	public void deleteImgProduto (int id_produto) throws SQLException, SocketException, IOException {
		
		List<Imagem> imagens = lista(id_produto);
		
		String query = "delete from img_produto where id_produto = ?";
		
		try(PreparedStatement pstmt = con.prepareStatement(query)){
			for (Imagem imagem : imagens) {
				pstmt.setInt(1, imagem.getId_produto());
				pstmt.execute();
				//deleta arquivo da pasta
				FTPClient ftp = new ConexaoFTP().getFtp();
				deletaArquivo(imagem.getNome_img(), ftp);
				ftp.logout();
				ftp.disconnect();
			}
		}
	}

	/**
	 * Realiza upload da imagem.
	 * @param nome_img
	 * @param item
	 * @throws Exception
	 */
	public void upload(String nome_img, FileItem item) {
		BufferedImage imagem = null;
		try {
			imagem = ImageIO.read(item.getInputStream());
			String url = ConstantesApp.CAMINHO_SERVIDOR + 
					ConstantesApp.CAMINHO_IMG + File.separator + nome_img + ".jpg";
			String url_tb =ConstantesApp.CAMINHO_SERVIDOR + 
					ConstantesApp.CAMINHO_IMG + File.separator + "thumbnail" +
					File.separator + "tb_" + nome_img + ".jpg";
			//upload imagem principal
			ImageIO.write(redimensiona(imagem, 800), "jpg", new File(url));
			//upload imagem thumbnail
			ImageIO.write(redimensiona(imagem, 200), "jpg", new File(url_tb));
			
			FTPClient ftp = new ConexaoFTP().getFtp();
			uploadFTP(ftp, nome_img, url, url_tb);
			ftp.logout();
			ftp.disconnect();
			
		} catch (IOException ex) {
			System.out.println("Erro: "+ ex.getMessage());
		}
	}
	
	/**
	 * Redimensiona a imagem para realizar upload.
	 * @param imagem
	 * @param tamanho_min
	 * @return
	 */
	private BufferedImage redimensiona(BufferedImage imagem, int tamanho_min) {
		int  new_w = imagem.getWidth(), new_h = imagem.getHeight();
		
		double percent_w = (double)tamanho_min/new_w;
		double percent_h = (double)tamanho_min/new_h;
		
		if (percent_w > percent_h) {
			new_w = (int) (new_w * percent_w);
			new_h = (int) (new_h * percent_w);
		} else {
			new_w = (int) (new_w * percent_h);
			new_h = (int) (new_h * percent_h);
		}
		BufferedImage new_img = new BufferedImage(new_w, new_h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = new_img.createGraphics();
		g.drawImage(imagem,	0, 0, new_w, new_h, null);
		
		return new_img;
	}
	
	/**
	 * Deleta as imagens do disco.
	 * @param nomeImg
	 * @throws IOException 
	 * @throws SocketException 
	 */
	private void deletaArquivo(String nomeImg, FTPClient ftp) throws SocketException, IOException {
		File img = new File(ConstantesApp.CAMINHO_SERVIDOR + ConstantesApp.CAMINHO_IMG + File.separator + nomeImg + ".jpg" );
		img.delete();
		img = new File(ConstantesApp.CAMINHO_SERVIDOR + 
				ConstantesApp.CAMINHO_IMG + File.separator + "thumbnail" +
				File.separator + "tb_" + nomeImg + ".jpg");
		img.delete();
		
		//deleta do ftp
		ftp.changeWorkingDirectory("public_html/static/produtos");
		ftp.deleteFile(nomeImg + ".jpg");
		ftp.deleteFile("tb_" + nomeImg + ".jpg");
	}
	
	/**
	 * Envia imagens para o FTP
	 * @param ftp
	 * @param nome_img
	 * @param url
	 * @param url_tb
	 */
	public void uploadFTP(FTPClient ftp, String nome_img, String url, String url_tb) {
		
		try {			
			
			ftp.setFileTransferMode(FTPClient.BINARY_FILE_TYPE);
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftp.setControlKeepAliveTimeout(300);
			ftp.enterLocalPassiveMode();
			
			ftp.changeWorkingDirectory("public_html/static/produtos");
			if(ftp.storeFile(nome_img + ".jpg", new FileInputStream(url)))
				System.out.println("arquivo 1 enviado");
			else
				System.out.println("erro no envio");
			
//			ftp.changeWorkingDirectory("public_html/static/produtos/thumbnails");
			if(ftp.storeFile("tb_"+ nome_img + ".jpg", new FileInputStream(url_tb)))
				System.out.println("arquivo 2 enviado");
			else
				System.out.println("erro no envio");
			
		} catch (IOException ex) {
			System.out.println("Erro: "+ ex.getMessage());
		}

	}

}
