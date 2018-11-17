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

public class NovoProdutoForm implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		List<Categoria> listaCategorias;
		try (Connection con = new Conexao().getConnection()) {
			listaCategorias = new CategoriaDAO(con).lista();	
		}
		request.setAttribute("categorias", listaCategorias);
		
		return "forward:formNovoProduto";
	}

}
