package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {

	private String line;
	private String[] vetor;
	private static final String CAMINHO = "c:\\Temp\\ponto.txt";

	public Arquivo() {

	}

	public Arquivo(String line) {
		this.line = line;
	}

	public String getLine() {
		return line;
	}

	public String[] getVetor() {
		return vetor;
	}

	public String ler(String dia) {
		try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO))) {

			line = br.readLine();
			vetor = line.split(";");

			while (vetor[0].equals(dia) == false) {
				line = br.readLine();
				vetor = line.split(";");
			}

		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		} catch (NullPointerException e) {
			return line;
		}
		return line;
	}

	public void escrever(String dia, String hora) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(CAMINHO, true))) {

			ler(dia);

			if (line == null) {
				bw.newLine();
				bw.write(dia + ";" + hora);
			} else {
				bw.write(";" + hora);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

}
