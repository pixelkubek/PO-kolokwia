public class Pacjent {
    private KodPocztowy kodPocztowy;
    private int maksymalnaOdleglosc;
    private Szczepionka potrzebnaSzczepionka;
    private boolean zaszczepiony;

    public Pacjent(KodPocztowy kodPocztowy, int maksymalnaOdleglosc, Szczepionka potrzebnaSzczepionka) {
        this.kodPocztowy = kodPocztowy;
        this.maksymalnaOdleglosc = maksymalnaOdleglosc;
        this.potrzebnaSzczepionka = potrzebnaSzczepionka;
        this.zaszczepiony = false;
    }

    public Szczepionka getSzczepionka() {return potrzebnaSzczepionka;}
    public KodPocztowy getKodPocztowy() {return kodPocztowy;}
    public int getOdleglosc() {return maksymalnaOdleglosc;}
    public boolean getZaszczepienie() {return zaszczepiony;}

    public void zaszczep() {
        zaszczepiony = true;
    }
}