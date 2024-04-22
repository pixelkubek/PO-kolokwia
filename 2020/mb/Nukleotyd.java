public class Nukleotyd {
    public enum TypNukleotydu { A, C, G, T }

    private TypNukleotydu wartosc;

    public Nukleotyd(TypNukleotydu wartosc) {
        this.wartosc = wartosc;
    }

    public TypNukleotydu dajWartosc() {
        return wartosc;
    }

    public boolean takiSam(Nukleotyd n) {
        return this.wartosc == n.wartosc;
    }
}