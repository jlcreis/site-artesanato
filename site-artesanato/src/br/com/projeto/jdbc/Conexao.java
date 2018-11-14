package br.com.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

	private Connection con = null;
	
	public Conexao() {
		System.out.println("Conectando...");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/site-artesanato", "root", "reis587");
			System.out.println("Conectado.");
		} catch(ClassNotFoundException ex) {
			System.out.println("Classe não ecntrada, adicione o driver nas bibliotecas.");
			Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
		} catch(SQLException e) {
			System.out.println(e);
			throw new RuntimeException(e);
		}
	}
	
	public Connection getConnection() {
		return con;
	}
}
