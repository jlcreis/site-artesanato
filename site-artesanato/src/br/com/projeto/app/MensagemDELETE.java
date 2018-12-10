package br.com.projeto.app;

public class MensagemDELETE {
	
	public static String MSG = "";
	
	public void mensagemErro (int codigo, String nome_objeto, String nome_metodo) {
		
		if(codigo == 1451) {
			MSG =  "Não é possível "+ nome_metodo +". " + nome_objeto + " possui registros vinculados.";
		} else {
			MSG =  "Ocorreu um erro: "+ codigo;
		}
	}

}
