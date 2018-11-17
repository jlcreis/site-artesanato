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
import br.com.projeto.jdbc.dao.ProdutoDAO;
import br.com.projeto.modelo.Categoria;
import br.com.projeto.modelo.Produto;

public class EditarProduto implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		try(Connection con = new Conexao().getConnection()){
			ProdutoDAO buscaProduto = new ProdutoDAO(con);
			Produto produto = buscaProduto.select(id);
			CategoriaDAO categorias = new CategoriaDAO(con);
			List<Categoria> listaCategorias = categorias.lista();
			
			request.setAttribute("produto", produto);
			request.setAttribute("categorias", listaCategorias);
		}
		
		return "forward:formAlteraProduto";
	}

}
