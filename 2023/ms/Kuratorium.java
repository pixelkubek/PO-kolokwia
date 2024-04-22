package kolos_2022;

public class Kuratorium {
    private final Szkola[] _szkoly;

    private final Zyczenie[] _zyczenia;

    private final Uczen[] _uczniowie;

    public Kuratorium(Szkola[] szkoly, Zyczenie[] zyczenia, Uczen[] uczniowie){
        _szkoly=new Szkola[szkoly.length];
        System.arraycopy(szkoly,0,_szkoly,0, szkoly.length);
        _zyczenia=new Zyczenie[zyczenia.length];
        System.arraycopy(zyczenia,0,_zyczenia,0, zyczenia.length);
        _uczniowie=new Uczen[uczniowie.length];
        System.arraycopy(uczniowie,0,_uczniowie,0, uczniowie.length);
    }

    public Lista[] podziel(){
        int indeksAktualnegoZyczenia=0;
        while(indeksAktualnegoZyczenia < _zyczenia.length){
            if(obsluz(_zyczenia[indeksAktualnegoZyczenia])){
                indeksAktualnegoZyczenia++;
            }
            else{
                indeksAktualnegoZyczenia=0;
            }
        }
        return generujListy();
    }

    // Obsluguje życzenie. Zwraca true, jeśli powinno się realizowac następne życzenie lub false, gdy trzeba rozpatrzeć wszystkie od nowa (bo zwolniło się miejsce w klasie).
    private boolean obsluz(Zyczenie zyczenie){
        if(zyczenie.czySpelnione())
            return true;
        Szkola szkola = _szkoly[zyczenie.odczytajIdSzkoly()];
        if(!szkola.czyJestWolneMiejsce(zyczenie.odczytajIdKlasy())){
            return true;
        }

        // Jest wolne miejsce w klasie.
        if(!zyczenie.odczytajUcznia().czyChceZrealizowac(zyczenie.odczytajPriorytet())){
            // Życzenie o niższym priorytecie niz zrealizowane, nie ma co go rozpatrywać.
            zyczenie.ustawSpelnione(true);
            return true;
        }

        boolean realizujOdPoczatku = false;
        // Uczeń chce zrealizować to życzenie w tej chwili.
        if(zyczenie.odczytajUcznia().czyJuzPrzydzielony()){
            cofnijZyczenie(zyczenie.odczytajUcznia().odczytajAktualnieSpelnioneZyczenie());
            realizujOdPoczatku=true;
        }

        szkola.zapiszUcznia(zyczenie.odczytajIdKlasy(), zyczenie.odczytajUcznia());
        return realizujOdPoczatku;
    }

    private void cofnijZyczenie(Zyczenie zyczenie){
        Szkola szkola = _szkoly[zyczenie.odczytajIdSzkoly()];
        szkola.wypiszUcznia(zyczenie.odczytajIdKlasy(), zyczenie.odczytajUcznia());
    }

    private Lista[] generujListy(){
        Lista[] listy = new Lista[ileLacznieKlas()];
        int aktualnyIndeks = 0;
        for(int i = 0; i<_szkoly.length; i++){
            Lista[] listyWSzkole = _szkoly[i].generujListy();
            System.arraycopy(listyWSzkole,0,listy,aktualnyIndeks, listyWSzkole.length);
            aktualnyIndeks+=listyWSzkole.length;
        }
        return listy;
    }

    private int ileLacznieKlas(){
        int ileKlas = 0;
        for(int i = 0; i<_szkoly.length; i++){
            ileKlas+=_szkoly[i].ileKlas();
        }
        return ileKlas;
    }
}
