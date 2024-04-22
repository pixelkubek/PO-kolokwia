package kolos_2022;

public class Zyczenie {
    private final int _priorytet;

    private final int _idSzkoly;

    private final int _idKlasy;

    private final Uczen _uczen;

    private boolean _czySpelnione;

    public Zyczenie(int priorytet, int idSzkoly, int idKlasy, Uczen uczen){
        _priorytet=priorytet;
        _idSzkoly=idSzkoly;;
        _idKlasy=idKlasy;
        _uczen=uczen;
        _czySpelnione=false;
    }

    public int odczytajPriorytet(){
        return _priorytet;
    }

    public int odczytajIdSzkoly(){
        return _idSzkoly;
    }

    public int odczytajIdKlasy(){
        return _idKlasy;
    }

    public Uczen odczytajUcznia(){
        return _uczen;
    }

    public boolean czySpelnione(){
        return _czySpelnione;
    }

    public void ustawSpelnione(boolean czySpelnione){
        _czySpelnione=czySpelnione;
    }
}
