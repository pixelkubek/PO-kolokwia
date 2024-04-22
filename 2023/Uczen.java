package kolos_2022;

public class Uczen {
    private final String _pesel;

    private final Zyczenie[] _zyczenia;

    private int _aktualneZyczenie;

    public Uczen(String pesel, Zyczenie[] zyczenia){
        _pesel=pesel;
        _zyczenia = new Zyczenie[zyczenia.length];
        System.arraycopy(zyczenia,0,_zyczenia,0,zyczenia.length);
        _aktualneZyczenie=-1;
    }

    public String odczytajPesel(){
        return _pesel;
    }

    public void ustawObecnieSpelnioneZyczenie(int priorytet){
        _aktualneZyczenie=priorytet;
    }

    public int jakiAktualnieSpelnionyPriorytet(){
        return _aktualneZyczenie;
    }

    public Zyczenie odczytajAktualnieSpelnioneZyczenie(){
        if(_aktualneZyczenie == -1)
            return null;
        return _zyczenia[_aktualneZyczenie];
    }

    public boolean czyJuzPrzydzielony(){
        return jakiAktualnieSpelnionyPriorytet() != -1;
    }

    public boolean czyChceZrealizowac(int priorytet){
        if(jakiAktualnieSpelnionyPriorytet() == -1)
            return true;
        return priorytet < jakiAktualnieSpelnionyPriorytet();
    }
}
