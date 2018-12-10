package br.com.projeto.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.projeto.acao.Acao;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		String nomeDaClasse = "br.com.projeto.acao." + paramAcao;
		String nome = null;
		
		HttpSession sessao = request.getSession();
		boolean naoLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean acaoProtegida = (paramAcao.equals("Home"));
		
		if(acaoProtegida && naoLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			@SuppressWarnings("deprecation")
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String[] tipoEndereco = nome.split(":");

		if (tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1] + ".jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect("entrada?acao=" + tipoEndereco[1]);
		}

	}
}
