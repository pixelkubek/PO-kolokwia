import java.util.ArrayList;
import java.util.Random;

public class Talia {
    private ArrayList<Karta> karty;

    public Talia() {
        karty = new ArrayList<Karta>();

        for(WartoscKarty w : WartoscKarty.values()) {
            for(Kolor k : Kolor.values()) {
                karty.add(new Karta(w, k));
            }
        }
    }

    private void szufluj() {
        ArrayList<Karta> polowa1 = new ArrayList<Karta>();
        ArrayList<Karta> polowa2 = new ArrayList<Karta>();

        for(int i = 0; i < 26; i++) {
            polowa1.add(karty.get(i));
            polowa2.add(karty.get(i + 26));
        }

        karty.clear();

        for(int i = 0; i < 26; i++) {
            karty.add(polowa1.get(i));
            karty.add(polowa2.get(i));
        }
    }

    private void przeloz() {
        Random r = new Random();
        int punkt = r.nextInt(52);

        for(int i = 0; i < punkt; i++) {
            karty.add(karty.get(0));
            karty.remove(0);
        }
    }

    public void tasuj() {
        for(int i = 0; i < 5; i++) {
            szufluj();
            przeloz();
        }
    }

    public Karta popSzczyt() {
        Karta wynik = karty.get(karty.size() - 1);
        karty.remove(karty.size() - 1);
        return wynik;
    }
}
