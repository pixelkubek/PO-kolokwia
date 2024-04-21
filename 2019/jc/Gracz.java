public class Gracz {
    private String imie, nazwisko;
    private Reka reka;
    private int pieniadze;

    public Gracz(String imie, String nazwisko, int pieniadze) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pieniadze = pieniadze;
    }

    public Karta najstarszaKarta() {
        return reka.najstarszaKarta();
    }

    public boolean mozeGrac(int stawka) {
        return pieniadze >= stawka;
    }

    public void dodajPieniadze(int ilosc) {
        pieniadze += ilosc;
    }

    public void odejmijPieniadze(int ilosc) {
        pieniadze -= ilosc;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }

    public void dodajKarte(Karta k) {
        reka.dodajKarte(k);
    }

    public void nowaReka() {
        reka = new Reka();
    }

    public Reka getReka() {return reka;}

    public boolean dobrowolnieRezygnuje();
}
