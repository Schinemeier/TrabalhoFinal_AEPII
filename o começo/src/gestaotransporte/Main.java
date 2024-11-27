package gestaotransporte;
import java.util.Scanner;

public class Main {

	public void subMenu(String entidade) {
		Scanner scanner = new Scanner(System.in);
		int opcao;
		do {
		System.out.println("1 - LISTAR " + entidade);
		System.out.println("2 - CADASTRAR " + entidade);
		System.out.println("3 - EDITAR " + entidade);
		System.out.println("4 - REMOVER " + entidade);
		System.out.println("0 - VOLTAR");
		System.out.println();
		
		opcao = scanner.nextInt();
		
		switch (opcao) {
		case 1://LISTAR
			opcao("LISTAR", entidade);
			break;
		case 2://CADASTRAR
			opcao("CADASTRAR", entidade);
			break;
		case 3://EDITAR
			opcao("EDITAR", entidade);
			break;
		case 4://REMOVER
			opcao("REMOVER", entidade);
			break;

		case 0:
			return;
		default:
			System.out.println("OPCAO INVALIDA! TENTE NOVAMENTE.\n");
			break;
		}
		
		}while(opcao != 0);
		scanner.close();
		
	}
	
	public void opcao(String escolha, String entidade) {
		switch (entidade) {
		case "CLIENTE":
			GerenciarCliente.intermediar(escolha);
			break;
		
		case "MOTORISTA":
			GerenciarMotorista.intermediar(escolha);
			break;

		case "PRODUTO":
			GerenciarProduto.intermediar(escolha);
			break;
		}
	}
	
	public void viagens() {
		Scanner scanner = new Scanner(System.in);
		int opcao;
		do {
		System.out.println("1 - INICIAR VIAGEM");
		System.out.println("2 - FINALIZAR VIAGEM");
		System.out.println("0 - VOLTAR");
		System.out.println();
		
		opcao = scanner.nextInt();
		
		switch(opcao) {
		case 1:
			//
			break;
		case 2:
			//
			break;
		case 0:
			return;
		default:
			System.out.println("OPCAO INVALIDA! TENTE NOVAMENTE.\n");
			break;
		}
		}while(opcao != 0);
		scanner.close();
	}
	
	public void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcao;
		System.out.println("GESTÃO DE TRANSPORTADORA");

		do {
		System.out.println("MENU:");
		System.out.println("1 - GERENCIAR CLIENTE");
		System.out.println("2 - GERENCIAR MOTORISTA");
		System.out.println("3 - GERENCIAR PRODUTO");
		System.out.println("4 - GERENCIAR VIAGENS");
		System.out.println("0 - SAIR");
		System.out.println();
		opcao = scanner.nextInt();
		
		switch (opcao) {
		case 1:
			subMenu("CLIENTE");
			break;
		case 2:
			subMenu("MOTORISTA");
			break;
		case 3:
			subMenu("PRODUTO");
			break;
		case 4:
			viagens();
			break;

		case 0:
			System.exit(0);
			break;
	
		default:
			System.out.println("OPCAO INVALIDA! TENTE NOVAMENTE.\n");
			break;
		}
		
		}while(opcao != 0);
		scanner.close();
	}
	


}
