package kolos_2022;

public class Klasa {
    private final int _id;

    private final String _nazwa;

    private final int _liczbaMiejsc;

    private Uczen[] _uczniowie;

    private int _liczbaUczniow;

    public Klasa(int id, String nazwa,int liczbaMiejsc){
        _id=id;
        _nazwa=nazwa;
        _liczbaMiejsc=liczbaMiejsc;
        _uczniowie = new Uczen[_liczbaMiejsc];
        _liczbaUczniow=0;
    }

    public int odczytajId(){
        return _id;
    }

    public String odczytajNazwe(){
        return _nazwa;
    }

    public int ileMiejsc(){
        return _liczbaMiejsc;
    }

    public Uczen[] odczytajListe(){
        Uczen[] uczniowie = new Uczen[_liczbaUczniow];
        System.arraycopy(_uczniowie,0,uczniowie,0,_liczbaUczniow);
        return uczniowie;
    }

    public boolean czyJestMiejsce(){
        return _liczbaMiejsc > _liczbaUczniow;
    }

    public void zapiszUcznia(Uczen uczen){
        _uczniowie[_liczbaUczniow++]=uczen;
    }

    public void wypiszUcznia(Uczen uczen){
        int indeksUcznia = -1;
        for(int i = 0; i<_liczbaUczniow; i++){
            if(_uczniowie[i]==uczen){
                indeksUcznia=i;
                break;
            }
        }
        if(indeksUcznia == -1)
            return;
        _uczniowie[indeksUcznia]=_uczniowie[_liczbaUczniow-1];
        _uczniowie[_liczbaUczniow-1]=null;
        _liczbaUczniow--;
    }

    public String[] odczytajPesele(){
        String[] pesele = new String[_liczbaUczniow];
        for(int i = 0; i<_liczbaUczniow; i++){
            pesele[i] = _uczniowie[i].odczytajPesel();
        }
        return pesele;
    }
}
