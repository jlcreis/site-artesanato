package br.com.projeto.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.jdbc.Conexao;
import br.com.projeto.jdbc.dao.ProdutoDAO;

public class RemoveProduto implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		try(Connection con = new Conexao().getConnection()){
			ProdutoDAO removeProduto = new ProdutoDAO(con);
			removeProduto.delete(id);
		}
		
		return "redirect:ListaProdutos";
	}

}
