import java.util.ArrayList;
import java.util.List;

public class GerenciadorAluno {
    private List<Aluno> alunos;

    public GerenciadorAluno() {
        alunos = new ArrayList<>();
    }

    // Create: Adicionar um aluno
    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
        System.out.println("Aluno adicionado com sucesso: " + aluno.getNome());
    }

    // Read: Buscar um aluno pelo nome
    public Aluno buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equals(nome)) {
                return aluno;
            }
        }
        return null; // Se não encontrado
    }

    // Update: Atualizar um aluno já cadastrado
    public void atualizarAluno(String nome, Aluno alunoAtualizado) {
        Aluno aluno = buscarAluno(nome);
        if (aluno != null) {
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setIdade(alunoAtualizado.getIdade());
            aluno.setTelefone(alunoAtualizado.getTelefone());
            aluno.setPlano(alunoAtualizado.getPlano());
            System.out.println("Aluno atualizado: " + aluno.getNome());
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    // Delete: Remover um aluno
    public void removerAluno(String nome) {
        Aluno aluno = buscarAluno(nome);
        if (aluno != null) {
            alunos.remove(aluno);
            System.out.println("Aluno removido: " + aluno.getNome());
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    // Listar todos os alunos
    public void listarAlunos() {
        for (Aluno aluno : alunos) {
            System.out.println("Aluno: " + aluno.getNome() + " | Plano: " + aluno.getPlano().getNome());
        }
    }
}
