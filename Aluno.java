import java.util.ArrayList;
import java.util.List;

public class Aluno {
    private String nome;
    private int idade;
    private String telefone;
    private Plano plano;
    private List<Treino> treinos; // Lista de treinos do aluno

    public Aluno(String nome, int idade, String telefone, Plano plano) {
        this.nome = nome;
        this.idade = idade;
        this.telefone = telefone;
        this.plano = plano;
        this.treinos = new ArrayList<>();
    }

    // Métodos de CRUD para treinos
    public void adicionarTreino(Treino treino) {
        this.treinos.add(treino);
    }

    public void removerTreino(Treino treino) {
        this.treinos.remove(treino);
    }

    public List<Treino> getTreinos() {
        return treinos;
    }

    // Getters e setters para os demais atributos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
}
