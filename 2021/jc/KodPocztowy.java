public class KodPocztowy {
    private int kod;

    public KodPocztowy(int kodPocztowy) {
        kod = kodPocztowy;
    }

    public int getKod() {return kod;}
    public int getWojewodztwo() {return (kod - kod % 10000) / 10000;}
    public int getAdresWWojewodztwie() {return kod - getWojewodztwo() * 10000;}
    public int odleglosc(KodPocztowy kod2) {
        return Math.abs(this.kod - kod2.kod);
    }

    public int minimalnyAdres(int maksOdlegloscPacjenta) {
        return Math.max(0, getAdresWWojewodztwie() - maksOdlegloscPacjenta);
    }

    public int maksymalnyAdres(int maksOdlegloscPacjenta) {
        return Math.min(9999, getAdresWWojewodztwie() + maksOdlegloscPacjenta);
    }
}
