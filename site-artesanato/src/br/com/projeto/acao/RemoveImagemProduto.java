package br.com.projeto.acao;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.app.ConstantesApp;
import br.com.projeto.jdbc.Conexao;
import br.com.projeto.jdbc.dao.ImagemDAO;

public class RemoveImagemProduto implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String paramId = request.getParameter("id");
		String paramId_img = request.getParameter("id_img");
		String nomeImg = request.getParameter("nome");
		int id = Integer.valueOf(paramId);
		int id_img = Integer.valueOf(paramId_img);
		
		try(Connection con = new Conexao().getConnection()){
			ImagemDAO removeImagem = new ImagemDAO(con);
			removeImagem.delete(id_img, nomeImg);
		}
		
		File imagem = new File(ConstantesApp.CAMINHO_IMG +"\\"+ nomeImg + ".jpg" );
		imagem.delete();
		
		return "redirect:EditarProduto&id="+id;
//		return "redirect:NovaImagemForm&id="+id;
	}

}
