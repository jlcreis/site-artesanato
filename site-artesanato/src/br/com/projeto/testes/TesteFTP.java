package br.com.projeto.testes;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;

public class TesteFTP {
	
	public static void main(String[] args) throws SocketException, IOException {
		
		FTPClient ftp = new FTPClient();
		
		ftp.connect("ftp.lusartes.com.br");
		
		ftp.login("lusartes", "dYR_$6WZp}i?");
		
		ftp.changeWorkingDirectory("public_html/assets/images/produtos");
		
		String nomeImg = "IMG-20160902-WA0008.jpg";
		
		FileInputStream arqEnviar = new FileInputStream("D:/Projeto Empresa/site artesanato/Imagens/VendasMercadoLivre/Toalha de Rosto/"+nomeImg);
		
		ftp.setFileTransferMode(FTPClient.BINARY_FILE_TYPE);
		ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
		ftp.setControlKeepAliveTimeout(300);
		ftp.enterLocalPassiveMode();
		
		if(ftp.storeFile(nomeImg, arqEnviar))
			System.out.println("arquivo enviado");
		else
			System.out.println("erro no envio");
		
		String[] arq = ftp.listNames();
		
		
		System.out.println("Listando arquivos");
		
		for (String string : arq) {
			System.out.println(string);
		}
		
		ftp.logout();
		ftp.disconnect();
	}

}
