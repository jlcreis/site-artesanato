package br.com.projeto.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.jdbc.Conexao;
import br.com.projeto.jdbc.dao.CategoriaDAO;
import br.com.projeto.jdbc.dao.ImagemDAO;
import br.com.projeto.jdbc.dao.ProdutoDAO;
import br.com.projeto.modelo.Categoria;
import br.com.projeto.modelo.Imagem;
import br.com.projeto.modelo.Produto;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		try(Connection con = new Conexao().getConnection()){
			
			ProdutoDAO produtos = new ProdutoDAO(con);
			List<Produto> lista_produtos = produtos.top5();
			
			CategoriaDAO categorias = new CategoriaDAO(con);
			List<Categoria> lista_categorias = categorias.lista();
			
			request.setAttribute("categorias", lista_categorias);
			
			int count = 1;
			
			for (Produto p : lista_produtos) {
				List<Imagem> lista_imagens = new ImagemDAO(con).imgTop(p.getId_produto());
				p.setLista_imagens(lista_imagens);
				
				request.setAttribute("produto_"+ count, p);
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("WEB-INF/view/public/index.jsp").forward(request, response);
    }
    
}
