import java.util.ArrayList;
import java.util.List;

public class GerenciadorPlano {
    private List<Plano> planos;

    public GerenciadorPlano() {
        planos = new ArrayList<>();
    }

    // Create: Adicionar um plano
    public void adicionarPlano(Plano plano) {
        planos.add(plano);
        System.out.println("Plano adicionado: " + plano.getNome());
    }

    // Read: Buscar um plano pelo nome
    public Plano buscarPlano(String nome) {
        for (Plano plano : planos) {
            if (plano.getNome().equalsIgnoreCase(nome)) {
                return plano;
            }
        }
        return null; // Se não encontrado
    }

    // Update: Atualizar um plano existente
    public void atualizarPlano(String nome, Plano planoAtualizado) {
        Plano plano = buscarPlano(nome);
        if (plano != null) {
            plano.setNome(planoAtualizado.getNome());
            plano.setValorMensal(planoAtualizado.getValorMensal());
            System.out.println("Plano atualizado: " + plano.getNome());
        } else {
            System.out.println("Plano não encontrado.");
        }
    }

    // Delete: Remover um plano
    public void removerPlano(String nome) {
        Plano plano = buscarPlano(nome);
        if (plano != null) {
            planos.remove(plano);
            System.out.println("Plano removido: " + plano.getNome());
        } else {
            System.out.println("Plano não encontrado.");
        }
    }

    // Listar todos os planos
    public void listarPlanos() {
        for (Plano plano : planos) {
            System.out.println("Plano: " + plano.getNome() + " | Valor Mensal: " + plano.getValorMensal());
        }
    }
}
