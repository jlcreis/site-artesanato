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
import br.com.projeto.jdbc.dao.ProdutoDAO;
import br.com.projeto.modelo.Imagem;
import br.com.projeto.modelo.Produto;

public class MostraProduto implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		try(Connection con = new Conexao().getConnection()){
			ProdutoDAO buscaProduto = new ProdutoDAO(con);
			Produto produto = buscaProduto.select(id);
			
			int id_produto = Integer.valueOf(request.getParameter("id"));
			List<Imagem> lista = new ImagemDAO(con).lista(id_produto);
				
			request.setAttribute("listaImagens", lista);
			request.setAttribute("produto", produto);
		}
		
		return "forward:mostraProduto";
	}

}
