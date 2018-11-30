package br.com.projeto.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.jdbc.Conexao;
import br.com.projeto.jdbc.dao.CategoriaDAO;
import br.com.projeto.jdbc.dao.ImagemDAO;
import br.com.projeto.jdbc.dao.ProdutoDAO;
import br.com.projeto.modelo.Categoria;
import br.com.projeto.modelo.Imagem;
import br.com.projeto.modelo.Produto;

public class PublicProdutos implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
	
		try (Connection con = new Conexao().getConnection()) {
			
			List<Produto> listaProdutos;
			List<Categoria> listaCategorias = new CategoriaDAO(con).lista();
			
			if (id == 0) {
				listaProdutos = new ProdutoDAO(con).list();
			} else {
				listaProdutos = new ProdutoDAO(con).produtoCategoria(id);
			}
			for (Produto p : listaProdutos) {
				List<Imagem> imagem = new ImagemDAO(con).imgTop(p.getId_produto());
				p.setLista_imagens(imagem);
			}
			
			request.setAttribute("id", id);
			request.setAttribute("categorias", listaCategorias);
			request.setAttribute("produtos", listaProdutos);
		}



		return "forward:public/produtos";
	}

}
