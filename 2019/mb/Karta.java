public class Karta {
    public enum Kolor {
        Trefl, Karo, Kier, Pik
    };

    public enum Wartość {
        Dwa, Trzy, Cztery, Pięć, Sześć, Siedem, Osiem, Dziewięć, Dziesięć, Walet, Dama, Król, As
    }

    private Kolor kolor;
    private Wartość wartość;

    public Karta(Wartość wartość, Kolor kolor) {
        this.kolor = kolor;
        this.wartość = wartość;
    } 

    public String toString() {
        return wartość.toString() + kolor.toString();
    }

    public boolean większaNiż(Karta karta) {
        return  wartość.ordinal() > karta.wartość.ordinal() || 
                (wartość.ordinal() == karta.wartość.ordinal() && kolor.ordinal() > karta.kolor.ordinal());
    }
}
