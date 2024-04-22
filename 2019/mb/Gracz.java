public class Gracz {
    private int zasóbPieniędzy;
    private Ręka ręka;
    private String nazwa;

    public Gracz(int ilePieniędzy, String nazwa) {
        this.zasóbPieniędzy = ilePieniędzy;
        this.ręka = new Ręka();
        this.nazwa = nazwa;
    }

    public String toString() {
        return "Gracz: " + nazwa + "Karty: " + ręka;
    }

    public boolean zrezygnował() {
        return false;
    }

    public Ręka dajRękę() {
        return ręka;
    }

    public void zabierzPieniądze(int ile) {
        this.zasóbPieniędzy -= ile;
    }

    public void dajPieniądze(int ile) {
        this.zasóbPieniędzy += ile;
    }
} 
