package entities.tipos;

import java.text.SimpleDateFormat;
import java.util.Date;

import entities.Ponto;
import entities.Tipo;

public class VoltaAlmoco extends Ponto {
	
	private Tipo tipo;
	
	SimpleDateFormat dataF = new SimpleDateFormat("dd/MM/yyy");
	SimpleDateFormat horaF = new SimpleDateFormat("HH:mm");

	public VoltaAlmoco(String dia, String hora) {
		super(dia, hora);
		tipo = Tipo.VOLTA_ALMOCO;
	}

	public Tipo getTipo() {
		return tipo;
	}
	
	public String getDia() {
		return dia;
	}
	
	public String getHora() {
		return hora;
	}

	public void baterPonto() {
		dia = dataF.format(new Date());
		hora = horaF.format(new Date());
	}
	
	@Override
	public String toString() {
		return ";" + hora;
	}
}
