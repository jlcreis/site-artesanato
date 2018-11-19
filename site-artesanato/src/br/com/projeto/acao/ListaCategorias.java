package br.com.projeto.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.jdbc.Conexao;
import br.com.projeto.jdbc.dao.CategoriaDAO;
import br.com.projeto.modelo.Categoria;

public class ListaCategorias implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse rsponse)
			throws ServletException, IOException, SQLException {
				
		List<Categoria> listaCategorias = null;
		try (Connection con = new Conexao().getConnection()) {
			listaCategorias = new CategoriaDAO(con).lista();	

		}
		request.setAttribute("categorias", listaCategorias);
		
		return "forward:listaCategorias";
		
	}


}
