public class KwasNukleinowy {
    private Nukleotyd[] kwas;

    public KwasNukleinowy(Nukleotyd[] kwas) {
        this.kwas = kwas;
    }

    public int dajRozmiarKwasu() {
        return kwas.length;
    }

    public Nukleotyd dajNukleotyd(int indeks) {
        return kwas[indeks];
    }

    public void zmieńNukleotyd(int indeks, Nukleotyd wartosc) {
        kwas[indeks] = wartosc; 
    }
}