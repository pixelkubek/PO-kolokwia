public abstract class Metryka {
    public static final int NIESPELNIA_ZALOZEN = -1;

    // Zwraca odległość funkcji lub NIESPELNIA_ZALOZEN
    public final int obliczOdleglosc(Funkcja f, Funkcja g){
        if(!czySpelniajaZalozenia(f,g))
            return NIESPELNIA_ZALOZEN;
        return oblicz(f,g);
    }

    protected abstract int oblicz(Funkcja f, Funkcja g);

    public abstract boolean czySpelniajaZalozenia(Funkcja f, Funkcja g);
}
