import java.util.ArrayList;

public class Reka {
    private ArrayList<Karta> karty;

    public Reka() {
        karty = new ArrayList<Karta>();
    }

    public void dodajKarte(Karta karta) {
        karty.add(karta);
    }

    public Karta najstarszaKarta() {
        Karta wynik = karty.get(0);

        for(Karta k : karty) {
            if(k.wiekszaNiz(wynik)) {
                wynik = k;
            }
        }

        return wynik;
    }

    @Override
    public String toString() {
        String wynik = "";
        for(Karta k : karty) {
            wynik.concat(" " + k.toString());
        }
        return wynik;
    }
}
