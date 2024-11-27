package gestaotransporte;

import java.util.Scanner;

public class GerenciamentoCliente extends GerenciamentoEntidade<Cliente> {
    @Override
    public void cadastrarEntidade() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();
        System.out.println("Digite a cidade do cliente: ");
        String cidade = scanner.nextLine();

        entidades.add(new Cliente(nome, cpf, cidade));
        System.out.println("Cliente cadastrado com sucesso!");
        //scanner.close();
    }

    @Override
    public void editarEntidade() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ID ou Nome do cliente para editar: ");
        String entrada = scanner.nextLine();
        Cliente cliente = buscarPorIdOuNome(entrada);

        if (cliente != null) {
            System.out.println("Novo nome: ");
            cliente.setNome(scanner.nextLine());
            System.out.println("Novo CPF: ");
            cliente.setCpf(scanner.nextLine());
            System.out.println("Nova cidade: ");
            cliente.setCidade(scanner.nextLine());
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
        //scanner.close();
    }

    @Override
    protected int getId(Cliente cliente) {
        return cliente.getId();
    }

    private Cliente buscarPorIdOuNome(String entrada) {
        try {
            int id = Integer.parseInt(entrada);
            return entidades.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
        } catch (NumberFormatException e) {
            return entidades.stream().filter(c -> c.getNome().equalsIgnoreCase(entrada)).findFirst().orElse(null);
        }
    }

    public void menu(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n=== Gerenciar Clientes ===");
            System.out.println("1. Listar Clientes");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Editar Cliente");
            System.out.println("4. Remover Cliente");
            System.out.println("5. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    listarEntidades();
                    break;
                case 2:
                    cadastrarEntidade();
                    break;
                case 3:
                    editarEntidade();
                    break;
                case 4:
                    System.out.println("Digite o ID do cliente a ser removido: ");
                    int idRemover = scanner.nextInt();
                    removerEntidade(idRemover);
                    System.out.println("Cliente removido com sucesso!");
                    break;
                case 5:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }
}
