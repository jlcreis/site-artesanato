package br.com.projeto.acao;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaImagemProduto implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String imagem = request.getParameter("img_01");
		
		Path path = Paths.get(imagem);
		
		System.out.println(imagem);
		System.out.println(path);
		
		return "forward:formNovoImagemProduto";
	}

}
