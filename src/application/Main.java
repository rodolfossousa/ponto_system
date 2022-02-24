package application;

import java.util.Scanner;

import entities.Admin;
import entities.Usuario;
import exeptions.Escolha;
import exeptions.NomeInvalido;
import repository.Arquivo;
import service.BatePonto;

public class Main {

	public static void main(String[] args) throws NomeInvalido {

		Scanner sc = new Scanner(System.in);
		Escolha escolha = new Escolha('0');

		System.out.println("GH CONSULT");
		System.out.println("Escolha uma das alternativas abaixo:");
		System.out.println();
		System.out.println("1 - Fazer login");
		System.out.println("2 - Cadastrar Usuário");

		tentar(() -> {
			System.out.print("Insira -> ");
			char esc = sc.nextLine().charAt(0);
			escolha.setEscolha(esc);
			escolha.escolhaErrada(esc);
		});

		UI.clearScreen();
		if (escolha.getEscolha() == '1') {
			tentar(() -> {
				
				System.out.println();
				System.out.print("login:");
				sc.next();
				String login = sc.nextLine();
				System.out.print("senha:");
				String senha = sc.nextLine();

				Usuario usuario = new Usuario(login);
				usuario.validaSenha(login, senha);
			});

			System.out.println("Login realizado!");
		}

		if (escolha.getEscolha() == '2') {
			tentar(() -> {
				System.out.println();
				System.out.println("Entre com o login do Administrador: ");
				System.out.print("administrador:");
				String login = sc.nextLine();
				System.out.print("senha administrador:");
				String senha = sc.nextLine();
				Admin admin = new Admin();
				admin.validaAdmin(login, senha);
			});

			System.out.println("Admin logado.");

			tentar(() -> {
				System.out.println();
				System.out.println("Entre com os dados do usuário: ");
				System.out.print("usuario: ");
				String login = sc.nextLine();
				System.out.print("senha: ");
				String senha = sc.nextLine();
				Usuario usuario = new Usuario();
				usuario.cadastraUsuario(login, senha);
			});

			System.out.println("Usuario cadastrado!");

		}

		BatePonto bate = new BatePonto();

		System.out.println();
		System.out.println(bate);
		System.out.println();
		Arquivo arquivo = new Arquivo();
		Escolha escolha2 = new Escolha('0');

		System.out.println("Selecione a opção desejada: ");
		System.out.println("1 - Bater o ponto");
		System.out.println("2 - Verificar Ponto do Mês");
		System.out.println("3 - Sair");

		tentarNovamente(() -> {
			System.out.print("Insira -> ");
			char esc = sc.nextLine().charAt(0);
			escolha2.setEscolha(esc);
			escolha2.escolhaErrada(esc);
		});

		if (escolha2.getEscolha() == '1') {

			Escolha escolha3 = new Escolha('0');
			while (arquivo.getVetor().length != 5 || escolha3.getEscolha() != '2') {

				bate.batePonto();
				System.out.println(bate);
				System.out.println();
				if (arquivo.getVetor().length != 5) {
					System.out.println("Bater o próximo horário:");
					System.out.println("1 - Sim");
					System.out.println("2 - Não");
					
					tentar(() -> {
						System.out.print("Insira -> ");
						char esc = sc.nextLine().charAt(0);
						escolha3.setEscolha(esc);
						escolha3.escolhaErrada2(esc);
					});

				}
			}
		}
		sc.close();
	}

	public static void tentar(Runnable r) {
		while (true) {
			try {
				r.run();
				return;
			} catch (NomeInvalido e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void tentarNovamente(Runnable r) {
		while (true) {
			try {
				r.run();
				return;
			} catch (NomeInvalido e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
