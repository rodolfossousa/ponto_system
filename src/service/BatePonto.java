package service;

import java.text.SimpleDateFormat;
import java.util.Date;

import entities.tipos.Entrada;
import entities.tipos.IdaAlmoco;
import entities.tipos.Saida;
import entities.tipos.VoltaAlmoco;
import repository.Arquivo;

public class BatePonto {

	private Entrada entrada;
	private IdaAlmoco ida;
	private VoltaAlmoco volta;
	private Saida saida;
	private Arquivo arquivo;
	private String data;
	private String hora;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");

	public BatePonto() {

	}

	public void batePonto() {
		data = sdf.format(new Date());
		hora = sdf2.format(new Date());

		arquivo = new Arquivo();
		arquivo.ler(data);

		if (arquivo.getLine() == null) {
			entrada = new Entrada(data, hora);
			arquivo.escrever(entrada.getDia(), entrada.getHora());
		} else {

			switch (arquivo.getVetor().length) {

			case 2:
				ida = new IdaAlmoco(data, hora);
				arquivo.escrever(ida.getDia(), ida.getHora());
				break;
			case 3:
				volta = new VoltaAlmoco(data, hora);
				arquivo.escrever(volta.getDia(), volta.getHora());
				break;
			case 4:
				saida = new Saida(data, hora);
				arquivo.escrever(saida.getDia(), saida.getHora());
				break;
			case 5:
				break;
			}
		}
	}

	@Override
	public String toString() {
		data = sdf.format(new Date());
		String retorno = "texto";

		arquivo = new Arquivo();
		
		arquivo.ler(data);
		String st = "do dia " + arquivo.getVetor()[0] + " computada às ";

		if (arquivo.getLine() == null) {
			retorno = "Dia  " + data + " ainda  não preenchido";
		} else {

			switch (arquivo.getVetor().length) {

			case 2:
				retorno =  "Entrada " + st + arquivo.getVetor()[1];
				break;
			case 3:
				retorno =  "Ida ao almoço " + st + arquivo.getVetor()[2];
				break;
			case 4:
				retorno =  "Volta do almoço " + st + arquivo.getVetor()[3];
				break;
			case 5:
				retorno = "Saida " + st + arquivo.getVetor()[4] + "\n" + "Dia completo! Retorne amanhã!";
				break;
			}
		}
		
		return retorno;
	}
}
