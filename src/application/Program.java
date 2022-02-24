package application;

import java.util.Scanner;

import entities.Admin;
import entities.Usuario;
import exeptions.NomeInvalido;

public class Program {

	public static void main(String[] args) throws NomeInvalido {

		Scanner sc = new Scanner(System.in);

		/*
		 * BatePonto bate = new BatePonto();
		 * 
		 * bate.batePonto();
		 * 
		 * System.out.println(bate);
		 */

		System.out.println("GH CONSULT");
		System.out.println("Escolha uma das alternativas abaixo:");
		System.out.println();
		System.out.println("1 - Fazer login");
		System.out.println("2 - Cadastrar Usuário");
		System.out.print("Insira -> ");
		char escolha = sc.nextLine().charAt(0);

		if (escolha == '1') {
			tentar(() -> {
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
