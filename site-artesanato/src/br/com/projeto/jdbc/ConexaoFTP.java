package br.com.projeto.jdbc;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;

public class ConexaoFTP {

	FTPClient ftp;

	public ConexaoFTP() throws IOException, SocketException{
		ftp = new FTPClient();
		System.out.println("conectando ftp..");
		ftp.connect("ftp.lusartes.com.br");

		ftp.login("lusartes", "dYR_$6WZp}i?");
		System.out.println("ftp conectado");
	}

	public FTPClient getFtp() {
		return ftp;
	}

}
