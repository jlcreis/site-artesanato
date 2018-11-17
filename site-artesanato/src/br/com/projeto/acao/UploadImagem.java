package br.com.projeto.acao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import br.com.projeto.app.ConstantesApp;
import br.com.projeto.jdbc.Conexao;
import br.com.projeto.jdbc.dao.ImagemDAO;


@MultipartConfig
public class UploadImagem implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		/*Identifica se o formulario é do tipo multipart/form-data*/
        if (ServletFileUpload.isMultipartContent(request)) {
        	
        	String nome_img = null;
        	
            try {
                /*Faz o parse do request*/
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(new ServletRequestContext(request));
                /*Escreve a o arquivo na pasta img*/
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                    	/*Cria o nome da imagem*/
                    	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
                    	Date dataAtual = new Date();
                    	Random gerador = new Random();
                    	nome_img = "IMG_"+ dateFormat.format(dataAtual) +"_"+ String.valueOf(gerador.nextInt(100000));
                    	/*Salva a imagem*/
                        item.write(new File(ConstantesApp.CAMINHO_IMG + File.separator + nome_img+".jpg"));
                        
                        try (Connection con = new Conexao().getConnection()) {
                			ImagemDAO dao = new ImagemDAO(con);
                			dao.insert(Integer.valueOf(multiparts.get(0).getFieldName()), nome_img);
                		}
                       
                    }
                }
 
                request.setAttribute("message", "Arquivo carregado com sucesso");
                request.setAttribute("nome_img", nome_img);
            } catch (Exception ex) {
                request.setAttribute("message", "Upload de arquivo falhou devido a "+ ex);
            }
 
        } else {
            request.setAttribute("message","Desculpe este Servlet lida apenas com pedido de upload de arquivos");
        }
		return "reditect:NovaImagemForm";
	}

}
