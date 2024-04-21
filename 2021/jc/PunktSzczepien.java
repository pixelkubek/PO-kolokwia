import java.util.ArrayList;

public class PunktSzczepien {
    private Szczepionka podawanaSzczepionka;
    private int pacjenciDziennie, najblizszyWolnyTermin;
    private KodPocztowy kodPunktu;

    private ArrayList<ArrayList<Pacjent>> pacjenciWDniu;

    public PunktSzczepien(Szczepionka szczepionka, int ilePacjentowDziennie, KodPocztowy kodPunktu) {
        pacjenciDziennie = ilePacjentowDziennie;
        pacjenciWDniu = new ArrayList<ArrayList<Pacjent>>();

        for(int i = 0; i < 365; i++)
            pacjenciWDniu.add(new ArrayList<Pacjent>());

        podawanaSzczepionka = szczepionka;
        najblizszyWolnyTermin = 0;

        this.kodPunktu = kodPunktu;
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

        najblizszyWolnyTermin = dzien + 1;
    }

    public boolean lepszyNiz(PunktSzczepien innyPunkt, Pacjent pacjent) {
        KodPocztowy kodPacjenta = pacjent.getKodPocztowy();
        if(this.najblizszyWolnyTermin < innyPunkt.najblizszyWolnyTermin) {
            return true;
        } else if(this.najblizszyWolnyTermin == innyPunkt.najblizszyWolnyTermin){
            if(kodPacjenta.odleglosc(this.kodPunktu) < kodPacjenta.odleglosc(innyPunkt.kodPunktu))
                return true;
            else 
                return false;
        } else {
            return false;
        }
    }
}