package kolos_2022;

public class Lista {
    private final int _idSzkoly;

    private final int _idKlasy;

    private final String[] _uczniowie;

    public Lista(int idSzkoly, int idKlasy, String[] uczniowie){
        _idSzkoly=idSzkoly;
        _idKlasy=idKlasy;
        _uczniowie = new String[uczniowie.length];
        System.arraycopy(uczniowie,0,_uczniowie,0, uczniowie.length);
    }

    public int odczytajIdSzkoly(){
        return _idSzkoly;
    }

    public int odczytajIdKlasy(){
        return _idKlasy;
    }

    public String[] odczytajPeseleUczniow(){
        String[] pesele = new String[_uczniowie.length];
        System.arraycopy(_uczniowie,0,pesele,0,_uczniowie.length);
        return pesele;
    }

    public int odczytajLiczbeUczniow(){
        return _uczniowie.length;
    }
}
