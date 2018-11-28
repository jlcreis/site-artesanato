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

public class ListaProdutos implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		System.out.println("Listando produtos ...");
		List<Produto> listaProdutos;
		try(Connection con = new Conexao().getConnection()){
			listaProdutos = new ProdutoDAO(con).list();
			for (Produto p : listaProdutos) {
				List<Imagem> imagem = new ImagemDAO(con).imgTop(p.getId_produto());
				p.setLista_imagens(imagem);
			}
		}
		request.setAttribute("produtos", listaProdutos);
		
		return "forward:listaProdutos";
	}

}
