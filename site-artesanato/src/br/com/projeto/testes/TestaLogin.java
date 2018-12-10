package br.com.projeto.testes;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.projeto.jdbc.Conexao;
import br.com.projeto.jdbc.dao.UsuarioDAO;
import br.com.projeto.modelo.Usuario;

public class TestaLogin {

	public static void main(String[] args) throws SQLException {

		search("jlc.reis@outlook.com", "xxx");
		search("jlc.reis@outlook.com.br", "adm");
		search("jlc.reis@outlook.com", "adm");
		
	}

	

	/**
	 * Teste de selecão de uma categoria
	 * @param id_categoria
	 * @throws SQLException
	 */
	private static void search(String email, String senha) throws SQLException {
		try(Connection con = new Conexao().getConnection()){
			UsuarioDAO busca = new UsuarioDAO(con);
			Usuario usuario = busca.search(email, senha);

			if(usuario != null) {
        		System.out.println("Usuario "+usuario.getNome()+" existe");
        	} else {
        		System.out.println("Usuario não existe");
        	}
		}
		
	}


	


	


}