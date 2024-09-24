public class Plano {
    private String nome;
    private double valorMensal;

    public Plano(String nome, double valorMensal) {
        this.nome = nome;
        this.valorMensal = valorMensal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }
}
