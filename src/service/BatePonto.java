package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entities.Ponto;
import entities.tipos.Entrada;
import entities.tipos.IdaAlmoco;
import entities.tipos.Saida;
import entities.tipos.VoltaAlmoco;

public class BatePonto {

	private Ponto ponto;
	private Date dataHoje = new Date();
	
	public BatePonto() {
		
	}
	
	public BatePonto(Ponto ponto) {
		this.ponto = ponto;
	}

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");

	String caminho = "c:\\Temp\\ponto.txt";

	public void batePonto() {

		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true))) {

				String line = br.readLine();
				String data = sdf.format(dataHoje);
				String horario = sdf2.format(dataHoje);
				
				if (line == null) {					
					Entrada entrada = new Entrada(data, horario);
					entrada.baterPonto();
					bw.write(data + ";" + entrada.getHora());									
				} 
				
				String[] vetor = line.split(";");
				
				switch (vetor.length) {				
				case 2:
					IdaAlmoco idaAlmoco = new IdaAlmoco(data, horario);
					bw.write(";" + idaAlmoco.getHora());
					break;
				case 3:
					VoltaAlmoco voltaAlmoco = new VoltaAlmoco(data, horario);
					bw.write(";" + voltaAlmoco.getHora());
					break;
				case 4:
					Saida saida = new Saida(data, horario);
					bw.write(";" + saida.getHora());
					break;					
				}
			
			}
		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
