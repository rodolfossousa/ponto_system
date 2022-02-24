package exeptions;

public class NomeInvalido extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NomeInvalido(String msg) {
		super(msg);
	}

}
