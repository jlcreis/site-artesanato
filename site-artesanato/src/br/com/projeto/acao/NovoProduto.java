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

public class NovoProduto implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String paramValor = request.getParameter("valor");
		Double valor = Double.valueOf(paramValor);
		String paramCategoria = request.getParameter("categoria");
		Categoria categoria = new Categoria (Integer.valueOf(paramCategoria));
		
		int empresa = 1;
		int id_produto = 0;
		
		try (Connection con = new Conexao().getConnection()) {
			Produto novoProduto = new Produto(nome, descricao, valor, categoria, empresa);
			ProdutoDAO dao = new ProdutoDAO(con);
			id_produto = dao.insert(novoProduto);
			
		}
		
//		request.setAttribute("id_produto", id_produto);
		
		return "redirect:EditarProduto&id="+ id_produto;
	}

}
