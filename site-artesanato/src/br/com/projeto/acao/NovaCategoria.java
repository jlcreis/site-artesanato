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

public class NovaCategoria implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String novaCategoria = request.getParameter("nome_categoria");
		if (Categoria.valida(novaCategoria)) {

			try (Connection con = new Conexao().getConnection()) {
				CategoriaDAO dao = new CategoriaDAO(con);
				dao.insert(novaCategoria);

				System.out.println("cadastro realizado com sucesso");
			}
		} else {
			System.out.println("Nome da categoria inválido.");
		}

		return "redirect:ListaCategorias";
	}

}
