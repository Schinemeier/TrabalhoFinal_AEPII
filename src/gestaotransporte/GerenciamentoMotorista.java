package gestaotransporte;


import java.util.Scanner;

public class GerenciamentoMotorista extends GerenciamentoEntidade<Motorista> {
    @Override
    public void cadastrarEntidade() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do motorista: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o CPF do motorista: ");
        String cpf = scanner.nextLine();
        System.out.println("Digite a CNH do motorista: ");
        String cnh = scanner.nextLine();
        System.out.println("Digite a cidade do motorista: ");
        String cidade = scanner.nextLine();

        entidades.add(new Motorista(nome, cpf, cnh, cidade));
        System.out.println("Motorista cadastrado com sucesso!");
        //scanner.close();
    }

    @Override
    public void editarEntidade() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o ID ou Nome do motorista para editar: ");
        String entrada = scanner.nextLine();
        Motorista motorista = buscarPorIdOuNome(entrada);

        if (motorista != null) {
            System.out.println("Novo nome: ");
            motorista.setNome(scanner.nextLine());
            System.out.println("Novo CPF: ");
            motorista.setCpf(scanner.nextLine());
            System.out.println("Digite a cnh do motorista: ");
            motorista.setCnh(scanner.nextLine());
            System.out.println("Nova cidade: ");
            motorista.setCidade(scanner.nextLine());
            System.out.println("Motorista atualizado com sucesso!");
        } else {
            System.out.println("Motorista não encontrado.");
        }
        //scanner.close();
    }

    @Override
    protected int getId(Motorista motorista) {
        return motorista.getId();
    }

    private Motorista buscarPorIdOuNome(String entrada) {
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
            System.out.println("\n=== Gerenciar Motoristas ===");
            System.out.println("1. Listar Motoristas");
            System.out.println("2. Cadastrar Motorista");
            System.out.println("3. Editar Motorista");
            System.out.println("4. Remover Motorista");
            System.out.println("5. Voltar");
            System.out.println("Escolha uma opção: ");
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
                    System.out.println("Digite o ID do motorista a ser removido: ");
                    int idRemover = scanner.nextInt();
                    removerEntidade(idRemover);
                    System.out.println("Motorista removido com sucesso!");
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
