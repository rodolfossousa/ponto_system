package entities;

import exeptions.NomeInvalido;

public class Admin {

	private final static String ADMIN = "ADMIN";
	private final static String SENHA = "Guti0902";
	private String validacao;
	
	public Admin() {
		
	}
	
	public String getValidacao(){
		return validacao;
	}
	
	public void validaAdmin(String usuario, String senha) {
		
		if (usuario.equals("ADMIN") == false || senha.equals("Guti0902") == false) {
			throw new NomeInvalido("Admin não reconhecido!");
		}
		
		if (usuario.equals(ADMIN) && senha.equals(SENHA)) {
			validacao = "valido";			
		}
		else {
			validacao = "invalido";
		}
	}
}
