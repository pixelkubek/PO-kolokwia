public class Szczepionka {
    private String nazwa, producent;
    private int wielkoscMl;

    public Szczepionka(String nazwa, String producent, int wielkoscMl) {
        this.nazwa = nazwa;
        this.producent = producent;
        this.wielkoscMl = wielkoscMl;
    }

    public boolean rowne(Szczepionka szczepionka) {
        return this.nazwa == szczepionka.nazwa && this.producent == szczepionka.producent && this.wielkoscMl == szczepionka.wielkoscMl;
    }

    public String getNazwa() {return nazwa;}
    public String getProducent() {return producent;}
    public int getWielkoscMl() {return wielkoscMl;}
}