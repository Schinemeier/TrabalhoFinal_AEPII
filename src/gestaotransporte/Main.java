package gestaotransporte;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        GerenciamentoCliente gerenciamentoCliente = new GerenciamentoCliente();
        GerenciamentoMotorista gerenciamentoMotorista = new GerenciamentoMotorista();
        GerenciamentoProduto gerenciamentoProduto = new GerenciamentoProduto();
        GerenciamentoViagem gerenciamentoViagem = new GerenciamentoViagem(gerenciamentoCliente, gerenciamentoMotorista, gerenciamentoProduto);

        int opcao;
        do {
            System.out.println("\n=== Sistema de Gestão de Transporte de Carga ===");
            System.out.println("1. Gerenciar Clientes");
            System.out.println("2. Gerenciar Motoristas");
            System.out.println("3. Gerenciar Produtos");
            System.out.println("4. Gerenciar Viagens");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    gerenciamentoCliente.menu(scanner);
                    break;
                case 2:
                    gerenciamentoMotorista.menu(scanner);
                    break;
                case 3:
                    gerenciamentoProduto.menu(scanner);
                    break;
                case 4:
                    gerenciamentoViagem.menu(scanner);
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        //scanner.close();
    }
}
