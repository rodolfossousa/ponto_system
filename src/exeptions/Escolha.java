package exeptions;

public class Escolha {

	private char escolha;
	
	public Escolha () {
		
	}

	public Escolha(char escolha) {
		this.escolha = escolha;
	}

	public char getEscolha() {
		return escolha;
	}
	
	public void setEscolha(char escolha) {
		this.escolha = escolha;
	}

	public void escolhaErrada(char escolha) {
		if (escolha != '1' && escolha != '2' && escolha != '3') {
			throw new NomeInvalido("\n Escolha não reconhecida. Tente Novamente! \n");
		}
	}
	
	public void escolhaErrada2(char escolha) {
		if (escolha != '1' && escolha != '2') {
			throw new NomeInvalido("\n Escolha não reconhecida. Tente Novamente! \n");
		}
	}
}
