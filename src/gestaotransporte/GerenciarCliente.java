package gestaotransporte;
import java.io.Serializable;

import java.util.Scanner;

public class GerenciarCliente implements Serializable {
	

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
		//System.out.println();
		//System.out.println(Pessoa.cidade);
			
	}
	
	public static void cadastrar() {
		Scanner scanner = new Scanner(System.in);
		Pessoa[] cliente = new Pessoa[1];
		Integer tamanhoArray = 0;

		System.out.println("Digite o nome: ");
		String nome = scanner.nextLine();
		
		System.out.println("Digite o CPF: ");
		String cpf = scanner.nextLine();
		
		System.out.println("Digite a cidade: ");
		String cidade = scanner.nextLine();
		
		scanner.close();
				
		cliente[tamanhoArray] = new Pessoa(nome, cpf, cidade);
		SalvarCarregar.salvar(cliente);

		tamanhoArray ++;
	}
	
	public static void editar() {
		
	}
		
	public static void remover() {
		
	}
	
	
	
}
