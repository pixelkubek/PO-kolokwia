import java.util.Arrays;

public class HammingDistance extends Metryka{
    @Override
    protected int oblicz(Funkcja f, Funkcja g) {
        int dystans = 0;
        int[] wspolnaDziedzina = f.odczytajDziedzine();
        for(int argument : wspolnaDziedzina){
            dystans+=Math.abs(f.aplikuj(argument) - g.aplikuj(argument));
        }
        return dystans;
    }

    @Override
    public boolean czySpelniajaZalozenia(Funkcja f, Funkcja g) {
        int[] dziedzinaF = f.odczytajDziedzine();
        int[] dziedzinaG = g.odczytajDziedzine();
        return Arrays.equals(dziedzinaF, dziedzinaG);
    }
}
