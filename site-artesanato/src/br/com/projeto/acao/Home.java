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

public class Home implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
				
		try(Connection con = new Conexao().getConnection()){
			ProdutoDAO produtos = new ProdutoDAO(con);
			List<Produto> lista_produtos = produtos.top5();
			
			int count = 1;
			
			for (Produto p : lista_produtos) {
				List<Imagem> lista_imagens = new ImagemDAO(con).imgTop(p.getId_produto());
//				List<Imagem> lista_imagens = new ImagemDAO(con).lista(p.getId_produto());
				p.setLista_imagens(lista_imagens);
				
				request.setAttribute("produto_"+ count, p);
				count++;
			}
			
//			for (Produto produto : lista_produtos) {
//				request.setAttribute("produto_"+ count, produto);
//				count++;
//			}
//		
//			request.setAttribute("produtos", lista_produtos);
		}
		
		return "forward:home";
	}

}
