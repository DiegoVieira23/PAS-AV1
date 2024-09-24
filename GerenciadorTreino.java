import java.util.ArrayList;
import java.util.List;

public class GerenciadorTreino {
    private List<Treino> treinos;

    public GerenciadorTreino() {
        treinos = new ArrayList<>();
    }

    // Create: Adicionar um treino
    public void adicionarTreino(Treino treino) {
        treinos.add(treino);
        System.out.println("Treino adicionado com sucesso.");
    }

    // Read: Buscar um treino pelo índice (exemplo simplificado)
    public Treino buscarTreino(int index) {
        if (index >= 0 && index < treinos.size()) {
            return treinos.get(index);
        }
        return null; // Se não encontrado
    }

    // Update: Atualizar um treino existente
    public void atualizarTreino(int index, Treino treinoAtualizado) {
        Treino treino = buscarTreino(index);
        if (treino != null) {
            treinos.set(index, treinoAtualizado);
            System.out.println("Treino atualizado com sucesso.");
        } else {
            System.out.println("Treino não encontrado.");
        }
    }

    // Delete: Remover um treino
    public void removerTreino(int index) {
        Treino treino = buscarTreino(index);
        if (treino != null) {
            treinos.remove(treino);
            System.out.println("Treino removido com sucesso.");
        } else {
            System.out.println("Treino não encontrado.");
        }
    }

    // Listar todos os treinos
    public void listarTreinos() {
        for (int i = 0; i < treinos.size(); i++) {
            System.out.println("Treino " + i + ": " + treinos.get(i).getClass().getSimpleName());
        }
    }
}
