package entities;

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
		if (usuario == ADMIN && senha == SENHA) {
			validacao = "valido";
		}
		else {
			validacao = "invalido";
		}
	}
}
