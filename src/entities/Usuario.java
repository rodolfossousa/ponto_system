package entities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import exeptions.NomeInvalido;

public class Usuario {

	private String nome;
	private String senha;
	private final static String CAMINHO = "c:\\Temp\\usuario.txt";
	private String[] vetor;
	private String line;
	private String valida;
	private Admin admin = new Admin();

	public Usuario() {

	}

	public Usuario(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void alteraSenha(String senha) {
		this.senha = senha;
	}

	public void validaSenha(String usuario, String senha) {
		try (BufferedReader br = new BufferedReader(new FileReader(CAMINHO))) {

			line = br.readLine();
			vetor = line.split(";");

			while (vetor[0].equals(usuario)) {
				line = br.readLine();
				vetor = line.split(";");			
			}

			if (senha.equals(vetor[1])) {
				valida = "valida";
			} else {
				throw new NomeInvalido("Senha invalida!");
			}

		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void cadastraUsuario(String nome, String senha) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(CAMINHO, true))) {		
			
			if (senha.length() < 6) {
				throw new NomeInvalido("A senha deve conter 6 caracteres ou mais!");
			}
				bw.newLine();
				bw.write(nome + ";" + senha);

		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

}
