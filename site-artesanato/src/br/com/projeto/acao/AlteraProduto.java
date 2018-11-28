package br.com.projeto.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.jdbc.Conexao;
import br.com.projeto.jdbc.dao.ProdutoDAO;
import br.com.projeto.modelo.Categoria;
import br.com.projeto.modelo.Produto;

public class AlteraProduto implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		System.out.println(request.getParameter("categoria"));
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String paramValor = request.getParameter("valor");
		Double valor = Double.valueOf(paramValor);
		String paramCategoria = request.getParameter("categoria");
		Categoria categoria = new Categoria (Integer.valueOf(paramCategoria));
//		Integer categoria = Integer.valueOf(paramCategoria);
		
		try(Connection con = new Conexao().getConnection()){
			Produto produto = new Produto(id, nome, descricao, valor, categoria);
			ProdutoDAO update = new ProdutoDAO(con);
			update.update(produto);
		}
		
		return "redirect:MostraProduto&id="+ id;
	}

}
