package br.com.projeto.servlet;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import br.com.projeto.app.ConstantesApp;
import br.com.projeto.jdbc.Conexao;
import br.com.projeto.jdbc.dao.ImagemDAO;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/upload")
@MultipartConfig
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Upload() {
        super();
    }
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		int id = 0;
		
		/*Identifica se o formulario é do tipo multipart/form-data*/
        if (ServletFileUpload.isMultipartContent(request)) {
        	
        	String nome_img = null;
        	
            try {
                /*Faz o parse do request*/
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(new ServletRequestContext(request));
                /*Escreve a o arquivo na pasta img*/
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                    	id = Integer.valueOf(multiparts.get(0).getFieldName());
                    	/*Cria o nome da imagem*/
                    	DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
                    	Date dataAtual = new Date();
                    	Random gerador = new Random();
                    	nome_img = "IMG_"+ dateFormat.format(dataAtual) +"_"+ String.valueOf(gerador.nextInt(100000));
                    	/*Salva a imagem*/
//                    	File pasta = new File(ConstantesApp.CAMINHO_SERVIDOR);
//                    	pasta.mkdir();
                        item.write(new File(ConstantesApp.CAMINHO_IMG + File.separator + nome_img+".jpg"));
                        //item.write(new File(request.getServletContext().getRealPath("img")+ File.separator + nome_img +".jpg"));
                        
                        try (Connection con = new Conexao().getConnection()) {
                			ImagemDAO dao = new ImagemDAO(con);
                			dao.insert(id, nome_img);

                		}
                    }
                }
 
                request.setAttribute("message", "Arquivo carregado com sucesso");
//              request.setAttribute("nome_img", nome_img);
            } catch (Exception ex) {
                request.setAttribute("message", "Upload de arquivo falhou devido a "+ ex);
            }
 
        } else {
            request.setAttribute("message","Desculpe este Servlet lida apenas com pedido de upload de arquivos");
        }
        
        
        response.sendRedirect("entrada?acao=EditarProduto&id="+ id);
//        response.sendRedirect("entrada?acao=NovaImagemForm&id="+ id);
//		request.getRequestDispatcher("WEB-INF/view/formNovoImagemProduto.jsp").forward(request, response);
    
	}

}
