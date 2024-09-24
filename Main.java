import java.util.Scanner;

public class Main {
    private static GerenciadorAluno gerenciadorAluno = new GerenciadorAluno();
    private static GerenciadorPlano gerenciadorPlano = new GerenciadorPlano();
    private static GerenciadorTreino gerenciadorTreino = new GerenciadorTreino();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;

        while (!sair) {
            System.out.println("\n=== Sistema de Gerenciamento de Academia ===");
            System.out.println("1. Gerenciar Alunos");
            System.out.println("2. Gerenciar Planos");
            System.out.println("3. Gerenciar Treinos");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    gerenciarAlunos();
                    break;
                case 2:
                    gerenciarPlanos();
                    break;
                case 3:
                    gerenciarTreinos();
                    break;
                case 4:
                    sair = true;
                    System.out.println("Saindo do sistema. Até mais!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }

    // Método para gerenciar Alunos
    private static void gerenciarAlunos() {
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\n--- Gerenciamento de Alunos ---");
            System.out.println("1. Adicionar Aluno");
            System.out.println("2. Buscar Aluno");
            System.out.println("3. Atualizar Aluno");
            System.out.println("4. Remover Aluno");
            System.out.println("5. Listar Alunos");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            
            int opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    adicionarAluno();
                    break;
                case 2:
                    buscarAluno();
                    break;
                case 3:
                    atualizarAluno();
                    break;
                case 4:
                    removerAluno();
                    break;
                case 5:
                    gerenciadorAluno.listarAlunos();
                    break;
                case 6:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Método para adicionar um Aluno
    private static void adicionarAluno() {
        System.out.print("Nome do Aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Idade do Aluno: ");
        int idade = lerInteiro();

        System.out.print("Telefone do Aluno: ");
        String telefone = scanner.nextLine();

        System.out.print("Nome do Plano: ");
        String nomePlano = scanner.nextLine();
        Plano plano = gerenciadorPlano.buscarPlano(nomePlano);
        if (plano == null) {
            System.out.println("Plano não encontrado. Adicione o plano primeiro.");
            return;
        }

        Aluno aluno = new Aluno(nome, idade, telefone, plano);
        gerenciadorAluno.adicionarAluno(aluno);
    }

    // Método para buscar um Aluno
    private static void buscarAluno() {
        System.out.print("Nome do Aluno para buscar: ");
        String nome = scanner.nextLine();
        Aluno aluno = gerenciadorAluno.buscarAluno(nome);
        if (aluno != null) {
            exibirDetalhesAluno(aluno);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    // Método para atualizar um Aluno
    private static void atualizarAluno() {
        System.out.print("Nome do Aluno para atualizar: ");
        String nome = scanner.nextLine();
        Aluno aluno = gerenciadorAluno.buscarAluno(nome);
        if (aluno != null) {
            System.out.print("Novo Nome (deixe em branco para manter o atual): ");
            String novoNome = scanner.nextLine();
            if (!novoNome.isEmpty()) {
                aluno.setNome(novoNome);
            }

            System.out.print("Nova Idade (ou 0 para manter a atual): ");
            int novaIdade = lerInteiro();
            if (novaIdade > 0) {
                aluno.setIdade(novaIdade);
            }

            System.out.print("Novo Telefone (deixe em branco para manter o atual): ");
            String novoTelefone = scanner.nextLine();
            if (!novoTelefone.isEmpty()) {
                aluno.setTelefone(novoTelefone);
            }

            System.out.print("Novo Plano (deixe em branco para manter o atual): ");
            String novoPlanoNome = scanner.nextLine();
            if (!novoPlanoNome.isEmpty()) {
                Plano novoPlano = gerenciadorPlano.buscarPlano(novoPlanoNome);
                if (novoPlano != null) {
                    aluno.setPlano(novoPlano);
                } else {
                    System.out.println("Plano não encontrado. Mantendo o plano atual.");
                }
            }

            gerenciadorAluno.atualizarAluno(nome, aluno);
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    // Método para remover um Aluno
    private static void removerAluno() {
        System.out.print("Nome do Aluno para remover: ");
        String nome = scanner.nextLine();
        gerenciadorAluno.removerAluno(nome);
    }

    // Método para exibir detalhes de um Aluno
    private static void exibirDetalhesAluno(Aluno aluno) {
        System.out.println("\n--- Detalhes do Aluno ---");
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Idade: " + aluno.getIdade());
        System.out.println("Telefone: " + aluno.getTelefone());
        System.out.println("Plano: " + aluno.getPlano().getNome());
        System.out.println("Treinos:");
        for (Treino treino : aluno.getTreinos()) {
            System.out.println(" - " + treino.getClass().getSimpleName());
        }
    }

    // Método para gerenciar Planos
    private static void gerenciarPlanos() {
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\n--- Gerenciamento de Planos ---");
            System.out.println("1. Adicionar Plano");
            System.out.println("2. Buscar Plano");
            System.out.println("3. Atualizar Plano");
            System.out.println("4. Remover Plano");
            System.out.println("5. Listar Planos");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            
            int opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    adicionarPlano();
                    break;
                case 2:
                    buscarPlano();
                    break;
                case 3:
                    atualizarPlano();
                    break;
                case 4:
                    removerPlano();
                    break;
                case 5:
                    gerenciadorPlano.listarPlanos();
                    break;
                case 6:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Método para adicionar um Plano
    private static void adicionarPlano() {
        System.out.print("Nome do Plano: ");
        String nome = scanner.nextLine();

        System.out.print("Valor Mensal do Plano: ");
        double valorMensal = lerDouble();

        Plano plano = new Plano(nome, valorMensal);
        gerenciadorPlano.adicionarPlano(plano);
    }

    // Método para buscar um Plano
    private static void buscarPlano() {
        System.out.print("Nome do Plano para buscar: ");
        String nome = scanner.nextLine();
        Plano plano = gerenciadorPlano.buscarPlano(nome);
        if (plano != null) {
            exibirDetalhesPlano(plano);
        } else {
            System.out.println("Plano não encontrado.");
        }
    }

    // Método para atualizar um Plano
    private static void atualizarPlano() {
        System.out.print("Nome do Plano para atualizar: ");
        String nome = scanner.nextLine();
        Plano plano = gerenciadorPlano.buscarPlano(nome);
        if (plano != null) {
            System.out.print("Novo Nome (deixe em branco para manter o atual): ");
            String novoNome = scanner.nextLine();
            if (!novoNome.isEmpty()) {
                plano.setNome(novoNome);
            }

            System.out.print("Novo Valor Mensal (ou 0 para manter o atual): ");
            double novoValor = lerDouble();
            if (novoValor > 0) {
                plano.setValorMensal(novoValor);
            }

            gerenciadorPlano.atualizarPlano(nome, plano);
        } else {
            System.out.println("Plano não encontrado.");
        }
    }

    // Método para remover um Plano
    private static void removerPlano() {
        System.out.print("Nome do Plano para remover: ");
        String nome = scanner.nextLine();
        gerenciadorPlano.removerPlano(nome);
    }

    // Método para exibir detalhes de um Plano
    private static void exibirDetalhesPlano(Plano plano) {
        System.out.println("\n--- Detalhes do Plano ---");
        System.out.println("Nome: " + plano.getNome());
        System.out.println("Valor Mensal: R$ " + plano.getValorMensal());
    }

    // Método para gerenciar Treinos
    private static void gerenciarTreinos() {
        boolean voltar = false;

        while (!voltar) {
            System.out.println("\n--- Gerenciamento de Treinos ---");
            System.out.println("1. Adicionar Treino");
            System.out.println("2. Buscar Treino");
            System.out.println("3. Atualizar Treino");
            System.out.println("4. Remover Treino");
            System.out.println("5. Listar Treinos");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            
            int opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    adicionarTreino();
                    break;
                case 2:
                    buscarTreino();
                    break;
                case 3:
                    atualizarTreino();
                    break;
                case 4:
                    removerTreino();
                    break;
                case 5:
                    gerenciadorTreino.listarTreinos();
                    break;
                case 6:
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    // Método para adicionar um Treino
    private static void adicionarTreino() {
        System.out.println("Tipos de Treino:");
        System.out.println("1. Musculação");
        System.out.println("2. Crossfit");
        System.out.print("Escolha o tipo de Treino: ");
        int tipo = lerInteiro();

        Treino treino = null;
        switch (tipo) {
            case 1:
                treino = new TreinoMusculacao();
                break;
            case 2:
                treino = new TreinoCrossfit();
                break;
            default:
                System.out.println("Tipo de treino inválido.");
                return;
        }

        gerenciadorTreino.adicionarTreino(treino);
    }

    // Método para buscar um Treino
    private static void buscarTreino() {
        System.out.print("Índice do Treino para buscar: ");
        int index = lerInteiro();
        Treino treino = gerenciadorTreino.buscarTreino(index);
        if (treino != null) {
            exibirDetalhesTreino(treino);
        } else {
            System.out.println("Treino não encontrado.");
        }
    }

    // Método para atualizar um Treino
    private static void atualizarTreino() {
        System.out.print("Índice do Treino para atualizar: ");
        int index = lerInteiro();
        Treino treinoAtual = gerenciadorTreino.buscarTreino(index);
        if (treinoAtual != null) {
            System.out.println("Atualizando Treino: " + treinoAtual.getClass().getSimpleName());
            System.out.println("Escolha o novo tipo de Treino:");
            System.out.println("1. Musculação");
            System.out.println("2. Crossfit");
            System.out.print("Escolha o tipo de Treino: ");
            int tipo = lerInteiro();

            Treino novoTreino = null;
            switch (tipo) {
                case 1:
                    novoTreino = new TreinoMusculacao();
                    break;
                case 2:
                    novoTreino = new TreinoCrossfit();
                    break;
                default:
                    System.out.println("Tipo de treino inválido.");
                    return;
            }

            gerenciadorTreino.atualizarTreino(index, novoTreino);
        } else {
            System.out.println("Treino não encontrado.");
        }
    }

    // Método para remover um Treino
    private static void removerTreino() {
        System.out.print("Índice do Treino para remover: ");
        int index = lerInteiro();
        gerenciadorTreino.removerTreino(index);
    }

    // Método para exibir detalhes de um Treino
    private static void exibirDetalhesTreino(Treino treino) {
        System.out.println("\n--- Detalhes do Treino ---");
        treino.realizarTreino();
    }

    // Métodos auxiliares para leitura segura
    private static int lerInteiro() {
        while (true) {
            try {
                String entrada = scanner.nextLine();
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Por favor, insira um número inteiro: ");
            }
        }
    }

    private static double lerDouble() {
        while (true) {
            try {
                String entrada = scanner.nextLine();
                return Double.parseDouble(entrada);
            } catch (NumberFormatException e) {
                System.out.print("Entrada inválida. Por favor, insira um número válido: ");
            }
        }
    }
}
