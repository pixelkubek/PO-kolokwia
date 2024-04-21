import java.util.ArrayList;

public class PunktSzczepien {
    private Szczepionka podawanaSzczepionka;
    private int pacjenciDziennie, najblizszyWolnyTermin;
    // pacjenciWTymTerminie < pacjenciDziennie

    private ArrayList<ArrayList<Pacjent>> pacjenciWDniu;

    public PunktSzczepien(Szczepionka szczepionka, int ilePacjentowDziennie) {
        pacjenciDziennie = ilePacjentowDziennie;
        pacjenciWDniu = new ArrayList<>(365);
        podawanaSzczepionka = szczepionka;
        najblizszyWolnyTermin = 0;
    }

    public Szczepionka getSzczepionka() {return podawanaSzczepionka;}
    public int getNajblizszyWolnyTermin() {return najblizszyWolnyTermin;}

    public void umow(Pacjent pacjent) {
        pacjenciWDniu.get(najblizszyWolnyTermin).add(pacjent);

        if(pacjenciWDniu.get(najblizszyWolnyTermin).size() >= pacjenciDziennie) {
            najblizszyWolnyTermin++;
        }
    }

    public boolean poprawnaSzczepionka(Pacjent pacjent) {
        return podawanaSzczepionka.rowne(pacjent.getSzczepionka());
    }

    public ArrayList<Pacjent> raportujPacjentowZDnia(int dzien) {
        return pacjenciWDniu.get(dzien);
    }

    public void realizujSzczepieniaWDniu(int dzien) {
        for(Pacjent pacjent : pacjenciWDniu.get(dzien)) {
            pacjent.zaszczep();
        }
    }
}