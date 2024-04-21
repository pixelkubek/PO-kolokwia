public class FunkcjaTablicowa extends Funkcja {
    private static final int BRAK_POPRZEDNICH_WYWOLAN=-1;

    private final int[] _dziedzina;

    private final int[] _przeciwdziedzina;

    private int _poprzedniIndexWywolania;

    public FunkcjaTablicowa(int[] dziedzina, int[] przeciwdziedzina){
        if(dziedzina.length == 0)
            throw new IllegalArgumentException("Dziedzina nie może być pusta.");
        if(przeciwdziedzina.length == 0)
            throw new IllegalArgumentException("Przeciwdziedzina nie może być pusta.");
        if(dziedzina.length != przeciwdziedzina.length){
            throw new IllegalArgumentException("Rozmiar dziedziny i przeciwdziedziny musi być taki sam.");
        }

        _dziedzina = new int[dziedzina.length];
        kopiujISprawdzCzyNaturalne(dziedzina,_dziedzina);
        _przeciwdziedzina = new int[przeciwdziedzina.length];
        kopiujISprawdzCzyNaturalne(przeciwdziedzina,_przeciwdziedzina);
        _poprzedniIndexWywolania =BRAK_POPRZEDNICH_WYWOLAN;
    }

    // Zakładamy, że rozmiar tablic jest taki sam
    private static void kopiujISprawdzCzyNaturalne(int[] zrodlo, int [] cel){
        for(int i = 0; i<cel.length; i++){
            if(zrodlo[i] <0)
                throw new IllegalArgumentException("Wszystkie liczby muszą być naturalne.");
            cel[i]=zrodlo[i];
        }
    }

    @Override
    public int aplikuj(int x) {
        int index = znajdzIndexWDziedzinie(x);
        if(index == -1){
            throw new IllegalArgumentException("Argument nie należy do dziedziny.");
        }
        int wartosc = _przeciwdziedzina[index];
        _poprzedniIndexWywolania=index;
        return wartosc;
    }

    @Override
    public boolean czyWDziedzinie(int x) {
        return znajdzIndexWDziedzinie(x) != -1;
    }

    @Override
    public int[] odczytajDziedzine() {
        int[] dziedzina = new int[_dziedzina.length];
        System.arraycopy(_dziedzina,0,dziedzina,0, _dziedzina.length);
        return dziedzina;
    }

    @Override
    public int[] odczytajPrzeciwdziedzine() {
        int[] przeciwdziedzina = new int[_dziedzina.length];
        System.arraycopy(_przeciwdziedzina,0,przeciwdziedzina,0, _dziedzina.length);
        return przeciwdziedzina;
    }

    @Override
    public int obliczMase() {
        int masa = 0;
        for (int wartosc : _przeciwdziedzina) {
            masa += wartosc;
        }
        return masa;
    }

    private int znajdzIndexWDziedzinie(int x){
        if(_poprzedniIndexWywolania != BRAK_POPRZEDNICH_WYWOLAN){
            if(_dziedzina[_poprzedniIndexWywolania] == x)
                return _poprzedniIndexWywolania;
            if(_poprzedniIndexWywolania >0 && _dziedzina[_poprzedniIndexWywolania-1] == x)
                return _poprzedniIndexWywolania-1;
            if(_poprzedniIndexWywolania < _dziedzina.length-1 && _dziedzina[_poprzedniIndexWywolania+1] == x)
                return _poprzedniIndexWywolania+1;
        }

        int l = 0, p = _dziedzina.length -1;
        while(l<p){
            int pivot = (l+p)/2;
            if(_dziedzina[pivot] <=x){
                l=pivot;
            }
            else{
                p=pivot-1;
            }
        }
        if(_dziedzina[l]!=x)
            return -1;
        return l;
    }
}
