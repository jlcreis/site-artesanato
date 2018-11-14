package br.com.projeto.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.jdbc.Conexao;
import br.com.projeto.jdbc.dao.CategoriaDAO;

public class RemoveCategoria implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse rsponse)
			throws ServletException, IOException, SQLException {
		
		String paramId = request.getParameter("id");
		Integer id_categoria = Integer.valueOf(paramId);
		
		try(Connection con = new Conexao().getConnection()){
			CategoriaDAO removeCategoria = new CategoriaDAO(con);
			removeCategoria.delete(id_categoria);
		}
		
		return "redirect:ListaCategorias";
	}

}
