package br.com.projeto.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.jdbc.Conexao;
import br.com.projeto.jdbc.dao.CategoriaDAO;
import br.com.projeto.modelo.Categoria;

public class AlteraCategoria implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		if (Categoria.valida(request.getParameter("nome"))) {
			String nomeCategoria = request.getParameter("nome");
			String paramId = request.getParameter("id");
			Integer id_categoria = Integer.valueOf(paramId);

			try (Connection con = new Conexao().getConnection()) {
				Categoria categoria = new Categoria(id_categoria, nomeCategoria);
				CategoriaDAO update = new CategoriaDAO(con);
				update.update(categoria);
			}
	
		}
		
		return "redirect:ListaCategorias";
	}

}
