package gestaotransporte;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciarCliente implements Serializable {
	private List<Pessoa> clientes = new ArrayList<>();
	private int contadorId = 1000;

	public void intermediar(String escolha) {
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
	
	public void listar() {
		SalvarCarregar.carregar();
		if(clientes.isEmpty()){
			System.out.println("Nenhum cliente cadastrado");
		}else{
			System.out.println("Lista de clientes: ");
			for(Pessoa cliente : clientes){
				System.out.println(cliente);
			} 
		}
			
	}
	
	public void cadastrar() {
		Scanner scanner = new Scanner(System.in);
		//Pessoa[] cliente = new Pessoa[1];
		
		Integer tamanhoArray = 0;

		System.out.println("Digite o nome: ");
		String nome = scanner.nextLine();
		
		System.out.println("Digite o CPF: ");
		String cpf = scanner.nextLine();
		
		System.out.println("Digite a cidade: ");
		String cidade = scanner.nextLine();
		
		scanner.close();
		Pessoa cliente = new Pessoa(nome, cpf, cidade);
		clientes.add(cliente);
		//cliente[tamanhoArray] = new Pessoa(nome, cpf, cidade);
		//SalvarCarregar.salvar(cliente);

		tamanhoArray ++;
	}
	
	public static void editar() {
		
	}
		
	public static void remover() {
		
	}
	
	
	
}
