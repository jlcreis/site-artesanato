package br.com.projeto.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaCategoriaForm implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse rsponse)
			throws ServletException, IOException, SQLException {
		
		return "forward:formNovaCategoria";
	}

}
