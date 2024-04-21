import java.util.Arrays;

public class EarthMover extends Metryka{
    @Override
    public int oblicz(Funkcja f, Funkcja g) {
        int[] przeciwdziedzinaF = f.odczytajPrzeciwdziedzine();
        int[] przeciwdziedzinaG = g.odczytajPrzeciwdziedzine();
        int odleglosc = 0;
        int wartosc = 0;
        // Tak naprawdę wystarczy "przesuwać" różnice w wartościach od lewej do prawej o 1.
        for(int i = 0; i< przeciwdziedzinaF.length; i++){
            odleglosc+= Math.abs(wartosc);
            wartosc+=przeciwdziedzinaG[i] - przeciwdziedzinaF[i];
        }
        return odleglosc;
    }

    @Override
    public boolean czySpelniajaZalozenia(Funkcja f, Funkcja g) {
        return f.obliczMase() == g.obliczMase();
    }
}
