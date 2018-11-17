package br.com.projeto.app;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InicializaApp implements ServletContextListener {
		
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			ConstantesApp.CAMINHO_SERVIDOR = sce.getServletContext().getRealPath("/");
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	




}
