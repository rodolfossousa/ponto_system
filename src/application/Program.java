package application;

import java.util.Scanner;

import entities.Admin;
import entities.Usuario;
import exeptions.NomeInvalido;
import repository.Arquivo;
import service.BatePonto;

public class Program {

	public static void main(String[] args) throws NomeInvalido {

		Scanner sc = new Scanner(System.in);

		System.out.println("GH CONSULT");
		System.out.println("Escolha uma das alternativas abaixo:");
		System.out.println();
		System.out.println("1 - Fazer login");
		System.out.println("2 - Cadastrar Usuário");
		System.out.print("Insira -> ");
		char escolha = sc.nextLine().charAt(0);

		if (escolha == '1') {
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

		if (escolha == '2') {
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
		
		while (arquivo.getVetor().length != 5) {
			System.out.println("Deseja bater o ponto? ");
			System.out.println("1 - Sim");
			System.out.println("2 - Não");
			System.out.print("Insira -> ");
			escolha = sc.nextLine().charAt(0);
			if (escolha == '1') {
				bate.batePonto();
			} else {
				break;
			}

			System.out.println(bate);
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

}
