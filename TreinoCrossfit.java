public class TreinoCrossfit extends Treino {
    @Override
    protected void aquecimento() {
        System.out.println("Aquecimento dinâmico com corda.");
    }

    @Override
    protected void exercicios() {
        System.out.println("Exercícios de Crossfit: Burpees, Kettlebell Swing, Box Jump.");
    }

    @Override
    protected void descanso() {
        System.out.println("Descanso de 30 segundos entre os rounds.");
    }

    @Override
    protected void alongamento() {
        System.out.println("Alongamento pré-treino de Crossfit.");
    }
}