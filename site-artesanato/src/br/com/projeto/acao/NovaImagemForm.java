package br.com.projeto.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.jdbc.Conexao;
import br.com.projeto.jdbc.dao.ImagemDAO;
import br.com.projeto.modelo.Imagem;

public class NovaImagemForm implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		try (Connection con = new Conexao().getConnection()) {
			int id_produto = Integer.valueOf(request.getParameter("id"));
			List<Imagem> lista = new ImagemDAO(con).lista(id_produto);
			
			request.setAttribute("listaImagens", lista);
			request.setAttribute("id_produto", id_produto);
		}
		
		return "forward:formNovoImagemProduto";
	}

}
