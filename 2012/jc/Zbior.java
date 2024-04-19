package jc;
import java.util.ArrayList;

public class Zbior {
    private ArrayList<Prostokat> zawieraneProstokaty;

    public Zbior() {
        zawieraneProstokaty = new ArrayList<Prostokat>();
    }

    public int rozmiar() {
        return zawieraneProstokaty.size();
    }

    public boolean dodaj(Prostokat p) {
        for(Prostokat istniejacy : zawieraneProstokaty) {
            if(istniejacy.porownaj(p)) {
                return false;
            }
        }

        zawieraneProstokaty.add(p);
        return true;
    }

    public boolean dodaj(int x1, int y1, int x2, int y2) {
        return dodaj(new Prostokat(x1, y1, x2, y2));
    }
    
    /*
        W następnych kilku metodach jest pewien błąd związany
        z dodawaniem prostokątów do innych zbiorów, w c++ to powinny
        być const referencje, tutaj są zwykłe referencje.
    */
    public int dodaj(Zbior z) {
        int dodane = 0;
        for(Prostokat prostokat : z.zawieraneProstokaty) {
            if(this.dodaj(prostokat)) {
                dodane++;
            }
        }

        return dodane;
    }

    public Zbior punkt(int x, int y) {
        Zbior wynik = new Zbior();
        Punkt zawieranyPunkt = new Punkt(x, y);

        for(Prostokat prostokat : zawieraneProstokaty) {
            if(prostokat.zawiera(zawieranyPunkt)) {
                wynik.dodaj(prostokat);
            }
        }

        return wynik;
    }

    public Zbior wewnatrz(Prostokat p) {
        Zbior wynik = new Zbior();

        for(Prostokat prostokat : zawieraneProstokaty) {
            if(prostokat.wewnatrz(p)) {
                wynik.dodaj(prostokat);
            }
        }

        return wynik;
    }

    public void wyczysc() {
        zawieraneProstokaty.clear();
    }
}
