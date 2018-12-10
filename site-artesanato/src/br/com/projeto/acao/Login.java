package br.com.projeto.acao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.projeto.jdbc.Conexao;
import br.com.projeto.jdbc.dao.UsuarioDAO;
import br.com.projeto.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        System.out.println("Logando... ");
        try(Connection con = new Conexao().getConnection()){
        	
        	UsuarioDAO dao = new UsuarioDAO(con);
        	Usuario usuario = dao.search(login,senha);
        	
        	if(usuario != null) {
        		HttpSession sessao = request.getSession();
        		sessao.setAttribute("usuarioLogado", usuario);
        				
        		return "redirect:Home";
        	} else {
        		return "redirect:LoginForm";
        	}
        }

    }

}
