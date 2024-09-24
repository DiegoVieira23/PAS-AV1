public class TreinoMusculacao extends Treino {
    @Override
    protected void aquecimento() {
        System.out.println("Aquecimento no exercício com cargas leves.");
    }

    @Override
    protected void exercicios() {
        System.out.println("Exercícios de musculação: Supino, Agachamento, Remada, Puxada.");
    }

    @Override
    protected void descanso() {
        System.out.println("Descanso de 2 a 5 minutos entre as séries.");
    }

    @Override
    protected void alongamento() {
        System.out.println("Alongamento pré-treino.");
    }
}