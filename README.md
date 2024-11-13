# TrabalhoFinal_AEPII
 Trabalho Final - Algoritmos e Programação II

## Enunciado

Criar um sistema para gestão de transporte de carga, envolvendo o controle de clientes, motoristas, produtos e viagens. O sistema deverá permitir o cadastro e a gestão desses elementos, incluindo informações sobre carga transportada e a relação entre clientes e motoristas. A organização em classes e a hierarquia de herança devem ser planejadas pelos alunos, que devem aplicar os conceitos de encapsulamento, herança, polimorfismo e abstração.

Ao iniciar, o sistema deve apresentar os seguintes menus:
 * Gerenciar Cliente
 * Gerenciar Motorista
 * Gerenciar Produto
 * Gerenciar Viagens

Dentro de cada menu Gerenciar Cliente/Motorista/Produto deve apresentar o seguinte submenu:
 * Listar Entidades
 * Cadastrar Entidade
 * Editar Entidade
 * Remover Entidade

Ao editar uma Entidade deve fornecer este menu:
 * Buscar Entidade por ID
 * Buscar entidade por Nome 

Em seguida a aplicação deve exibir o cadastro da primeira ocorrência da busca, ou uma mensagem de erro caso não encontre nenhuma entidade.

A edição de uma entidade deve ser idêntica a o cadastro. Sempre sobrescrevendo as informações da entidade.

O menu Gerenciar Viagem deve conter as seguintes opções:

 * Iniciar Viagem (Cadastrar uma viagem)
 * Finalizar Viagem (Editar uma viagem com status Finalizada)

Ambas as operações Iniciar e Finalizar Viagem devem exibir a lista de viagens e solicitar o ID ou Descrição da viagem para proceder com a operação.

Atributos obrigatórios de cada entidade (ID não deve ser preenchido pelo usuário, o próprio sistema deve fazer essa gestão).

Cliente:
 * ID
 * Nome
 * CPF
 * Cidade

Motorista
 * ID
 * Nome
 * CPF
 * CNH
 * Cidade

Produto
 * ID
 * Nome
 * Quantidade

Viagem
 * Descrição
 * Cidade Origem
 * Cidade Destino
 * Lista de Produtos
 * Motorista
 * Cliente
 * Status [Iniciada, Finalizada]

Regras de negócio do sistema
 * Para iniciar uma viagem o usuário deve informar uma descrição, um Motorista, um Cliente e ao menos um Produto.
 * Um motorista só pode assumir uma viagem por vez, portanto não é permitido iniciar uma Viagem de um Motorista que já esteja em uma Viagem com status Iniciada