public abstract class Wirus {
    private int częstotliwośćMutacji;
    protected KwasNukleinowy kwasNukleinowy;

    public Wirus(int częstotliwośćMutacji, KwasNukleinowy kwasNukleinowy) {
        this.częstotliwośćMutacji = częstotliwośćMutacji;
        this.kwasNukleinowy = kwasNukleinowy;
    }

    public KwasNukleinowy dajKwasNukleinowy() {
        return kwasNukleinowy;
    }

    public int dajCzęstotliwośćMutacji() {
        return częstotliwośćMutacji;
    }

    public abstract void mutuj();
}