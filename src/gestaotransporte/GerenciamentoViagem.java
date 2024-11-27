package gestaotransporte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciamentoViagem {
    private List<Viagem> viagens = new ArrayList<>();
    private GerenciamentoCliente gerenciamentoCliente;
    private GerenciamentoMotorista gerenciamentoMotorista;
    private GerenciamentoProduto gerenciamentoProduto;

    public GerenciamentoViagem(GerenciamentoCliente cliente, GerenciamentoMotorista motorista, GerenciamentoProduto produto) {
        this.gerenciamentoCliente = cliente;
        this.gerenciamentoMotorista = motorista;
        this.gerenciamentoProduto = produto;
    }

    public void menu(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n=== Gerenciar Viagens ===");
            System.out.println("1. Iniciar Viagem");
            System.out.println("2. Finalizar Viagem");
            System.out.println("3. Listar Viagens");
            System.out.println("4. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    iniciarViagem(scanner);
                    break;
                case 2:
                    finalizarViagem(scanner);
                    break;
                case 3:
                    listarViagens();
                    break;
                case 4:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    private void iniciarViagem(Scanner scanner) {
        System.out.print("Descrição da viagem: ");
        String descricao = scanner.nextLine();

        System.out.print("Cidade de origem: ");
        String origem = scanner.nextLine();

        System.out.print("Cidade de destino: ");
        String destino = scanner.nextLine();

        System.out.println("Selecionando motorista...");
        Motorista motorista = selecionarMotorista(scanner);
        if (motorista == null) return;

        System.out.println("Selecionando cliente...");
        Cliente cliente = selecionarCliente(scanner);
        if (cliente == null) return;

        System.out.println("Selecionando produtos...");
        List<Produto> produtos = selecionarProdutos(scanner);
        if (produtos.isEmpty()) return;

        Viagem viagem = new Viagem(descricao, origem, destino, produtos, motorista, cliente);
        viagens.add(viagem);
        System.out.println("Viagem iniciada com sucesso: " + viagem);
    }

    private void finalizarViagem(Scanner scanner) {
        System.out.print("Digite o ID ou descrição da viagem a finalizar: ");
        String entrada = scanner.nextLine();
        Viagem viagem = buscarViagemPorIdOuDescricao(entrada);

        if (viagem != null && viagem.getStatus().equals("Iniciada")) {
            viagem.finalizar();
            System.out.println("Viagem finalizada com sucesso!");
        } else {
            System.out.println("Viagem não encontrada ou já finalizada.");
        }
    }

    private void listarViagens() {
        if (viagens.isEmpty()) {
            System.out.println("Nenhuma viagem registrada.");
        } else {
            viagens.forEach(System.out::println);
        }
    }

    private Motorista selecionarMotorista(Scanner scanner) {
        gerenciamentoMotorista.listarEntidades();
        System.out.print("Digite o ID do motorista: ");
        int idMotorista = scanner.nextInt();
        Motorista motorista = gerenciamentoMotorista.buscarPorId(idMotorista);

        if (motorista == null) {
            System.out.println("Motorista não encontrado.");
            return null;
        } else if (motorista.isOcupado()) {
            System.out.println("Motorista já está em outra viagem.");
            return null;
        }

        return motorista;
    }

    private Cliente selecionarCliente(Scanner scanner) {
        gerenciamentoCliente.listarEntidades();
        System.out.print("Digite o ID do cliente: ");
        int idCliente = scanner.nextInt();
        return gerenciamentoCliente.buscarPorId(idCliente);
    }

    private List<Produto> selecionarProdutos(Scanner scanner) {
        List<Produto> produtos = new ArrayList<>();
        int opcao;
        do {
            gerenciamentoProduto.listarEntidades();
            System.out.print("Digite o ID do produto para adicionar à viagem (0 para encerrar): ");
            opcao = scanner.nextInt();
            if (opcao != 0) {
                Produto produto = gerenciamentoProduto.buscarPorId(opcao);
                if (produto != null) produtos.add(produto);
            }
        } while (opcao != 0);

        return produtos;
    }

    private Viagem buscarViagemPorIdOuDescricao(String entrada) {
        try {
            int id = Integer.parseInt(entrada);
            return viagens.stream().filter(v -> v.getId() == id).findFirst().orElse(null);
        } catch (NumberFormatException e) {
            return viagens.stream().filter(v -> v.getDescricao().equalsIgnoreCase(entrada)).findFirst().orElse(null);
        }
    }
}
