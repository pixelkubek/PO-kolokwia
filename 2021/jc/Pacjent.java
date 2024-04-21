public class Pacjent {
    private KodPocztowy kodPocztowy;
    private int maksymalnaOdleglosc;
    private Szczepionka potrzebnaSzczepionka;
    private boolean zaszczepiony;
    private String pesel;

    public Pacjent(KodPocztowy kodPocztowy, int maksymalnaOdleglosc, Szczepionka potrzebnaSzczepionka, String pesel) {
        this.kodPocztowy = kodPocztowy;
        this.maksymalnaOdleglosc = maksymalnaOdleglosc;
        this.potrzebnaSzczepionka = potrzebnaSzczepionka;
        this.zaszczepiony = false;
        this.pesel = pesel;
    }

    public Szczepionka getSzczepionka() {return potrzebnaSzczepionka;}
    public KodPocztowy getKodPocztowy() {return kodPocztowy;}
    public int getOdleglosc() {return maksymalnaOdleglosc;}
    public boolean getZaszczepienie() {return zaszczepiony;}

    public void zaszczep() {
        zaszczepiony = true;
    }

    public int najmniejszyAdres() {
        return kodPocztowy.minimalnyAdres(maksymalnaOdleglosc);
    }

    public int najwiekszyAdres() {
        return kodPocztowy.maksymalnyAdres(maksymalnaOdleglosc);
    }
}