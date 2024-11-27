package gestaotransporte;

import java.util.Scanner;

public class GerenciamentoProduto extends GerenciamentoEntidade<Produto> {
    @Override
    public void cadastrarEntidade() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a quantidade do produto: ");
        Integer quantidade = Integer.parseInt(scanner.nextLine());

        entidades.add(new Produto(nome, quantidade));
        System.out.println("Produto cadastrado com sucesso!");
    }

    @Override
    public void editarEntidade() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ID ou Nome do produto para editar: ");
        String entrada = scanner.nextLine();
        Produto produto = buscarPorIdOuNome(entrada);

        if (produto != null) {
            System.out.print("Novo nome: ");
            produto.setNome(scanner.nextLine());
            System.out.print("Nova quantidade: ");
            produto.setQuantidade(Integer.parseInt(scanner.nextLine()));
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    @Override
    protected int getId(Produto produto) {
        return produto.getId();
    }

    private Produto buscarPorIdOuNome(String entrada) {
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
            System.out.println("\n=== Gerenciar Produtos ===");
            System.out.println("1. Listar Produtos");
            System.out.println("2. Cadastrar Produto");
            System.out.println("3. Editar Produto");
            System.out.println("4. Remover Produto");
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
                    System.out.print("Digite o ID do produto a ser removido: ");
                    int idRemover = scanner.nextInt();
                    removerEntidade(idRemover);
                    System.out.println("Produto removido com sucesso!");
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
