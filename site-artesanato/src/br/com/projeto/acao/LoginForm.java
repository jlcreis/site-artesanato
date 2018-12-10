package br.com.projeto.acao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginForm implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		HttpSession sessao = request.getSession();
		if (sessao.getAttribute("usuarioLogado") != null) {
			return "redirect:Home";
		}
		
		return "forward:formLogin";
	}

}
