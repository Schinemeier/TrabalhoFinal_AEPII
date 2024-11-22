package gestaotransporte;
import java.io.Serializable;

import java.util.Scanner;

public class GerenciarCliente {

	public static void intermediar(String escolha) {
		switch (escolha) {
		case "LISTAR":
			listar();
			break;
			
		case "CADASTRAR":
			cadastrar();
			break;
		
		case "EDITAR":
			editar();
			break;
		
		case "REMOVER":
			remover();
			break;
		}
	}
	
	public static void listar() {
		SalvarCarregar.carregar();
	}
	
	public static void cadastrar() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite o nome: ");
		String nome = scanner.nextLine();
		
		System.out.println("Digite o CPF: ");
		String cpf = scanner.nextLine();
		
		System.out.println("Digite a cidade: ");
		String cidade = scanner.nextLine();
		
		scanner.close();
		
		
		Pessoa pessoa = new Pessoa(nome, cpf, cidade);
		
		
		SalvarCarregar.salvar(pessoa);
	}
	
	public static void editar() {
		
	}
		
	public static void remover() {
		
	}
	
	
	
}
