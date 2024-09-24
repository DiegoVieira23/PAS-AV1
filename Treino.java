public abstract class Treino {
    public final void realizarTreino() {
        aquecimento();
        exercicios();
        descanso();
        alongamento();
    }

    protected abstract void aquecimento();
    protected abstract void exercicios();
    protected abstract void descanso();
    protected abstract void alongamento();
}
