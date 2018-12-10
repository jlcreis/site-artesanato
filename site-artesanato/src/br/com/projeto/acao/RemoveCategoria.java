package br.com.projeto.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.jdbc.Conexao;
import br.com.projeto.jdbc.dao.CategoriaDAO;


public class RemoveCategoria implements Acao {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		String paramId = request.getParameter("id");
		Integer id_categoria = Integer.valueOf(paramId);
		
		try(Connection con = new Conexao().getConnection()){
			CategoriaDAO removeCategoria = new CategoriaDAO(con);
			removeCategoria.delete(id_categoria);
		}
		catch (SQLException e) {
			String erro = "Não é possível remover categoria. "
					+ "Existem produtos cadastrados com nesta categoria.";
			System.err.println(e.getErrorCode() +": "+ e.getMessage());
			request.setAttribute("mensagem", erro);
			return "forward:mensagemErro";
		}
		
		
		return "redirect:ListaCategorias";
	}

}
