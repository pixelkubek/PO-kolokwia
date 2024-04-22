public class Szczepionka {
    private KwasNukleinowy uodporniaNa;

    public Szczepionka(KwasNukleinowy uodporniaNa) {
        this.uodporniaNa = uodporniaNa;
    }

    public KwasNukleinowy dajNaCoUodpornia() {
        return uodporniaNa;
    }
}