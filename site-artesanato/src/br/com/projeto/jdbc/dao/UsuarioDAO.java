package br.com.projeto.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.projeto.modelo.Usuario;

public class UsuarioDAO {
	
	private final Connection con;
	
	public UsuarioDAO(Connection con) {
		this.con = con;
	}
	
	public Usuario search(String email, String senha) throws SQLException{
		Usuario usuario = null;
		
		String query = "select * from usuarios where email_usuario = ? and senha_usuario = ?";
		
		try(PreparedStatement pstmt = con.prepareStatement(query)){
			pstmt.setString(1, email);
			pstmt.setString(2, senha);
			pstmt.execute();
			try (ResultSet rs = pstmt.getResultSet()) {
				while (rs.next()) {
					String nome_usuario = rs.getString("nome_usuario");
					String email_usuario = rs.getString("email_usuario");
					usuario = new Usuario(nome_usuario, email_usuario);
			
				}
			}
			
			
			return usuario;
		}
		
	}
}
