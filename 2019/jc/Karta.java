public class Karta {
    private WartoscKarty wartosc;
    private Kolor kolor;

    public Karta(WartoscKarty wartosc, Kolor kolor) {
        this.wartosc = wartosc;
        this.kolor = kolor;
    }

    @Override
    public String toString() {
        return wartosc + " " + kolor;
    }

    public boolean wiekszaNiz(Karta karta) {
        if(this.wartosc.compareTo(karta.wartosc) > 0) {
            return true;
        } else if(this.wartosc.compareTo(karta.wartosc) == 0) {
            return this.kolor.compareTo(karta.kolor) > 0;
        }

        return false;
    }
}
