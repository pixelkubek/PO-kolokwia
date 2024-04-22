package kolos_2022;

public class Szkola {
    private final int _id;

    private final Klasa[] _klasy;

    public Szkola(int id, Klasa[] klasy){
        _id=id;
        _klasy=new Klasa[klasy.length];
        System.arraycopy(klasy,0,_klasy,0,klasy.length);
    }

    public int odczytajid(){
        return _id;
    }

    public void zapiszUcznia(int idKlasy, Uczen uczen){
        _klasy[idKlasy].zapiszUcznia(uczen);
    }

    public void wypiszUcznia(int idKlasy, Uczen uczen){
        _klasy[idKlasy].wypiszUcznia(uczen);
    }

    public boolean czyJestWolneMiejsce(int idKlasy){
        return _klasy[idKlasy].czyJestMiejsce();
    }

    public Lista[] generujListy(){
        Lista[] listy = new Lista[_klasy.length];
        for(int i = 0; i<listy.length; i++){
            listy[i] = new Lista(_id, _klasy[i].odczytajId(), _klasy[i].odczytajPesele());
        }
        return listy;
    }

    public int ileKlas(){
        return _klasy.length;
    }
}
