public class Wojewodztwo {
    private int cyfra;
    private PunktSzczepien[][] punktySzczepien; // punktySzczepien[adres][nr. punktu]

    public Wojewodztwo(int numer, PunktSzczepien[][] punktySzczepien) {
        this.cyfra = numer;
        this.punktySzczepien = punktySzczepien;
    }

    public PunktSzczepien wskazPunkt(Pacjent pacjent) {
        PunktSzczepien najlepszyPunkt = null;
        for(int adres = pacjent.najmniejszyAdres(); adres <= pacjent.najwiekszyAdres(); adres++) {
            for(PunktSzczepien punkt : punktySzczepien[adres]) {
                if(punkt.poprawnaSzczepionka(pacjent) && (najlepszyPunkt == null || punkt.lepszyNiz(najlepszyPunkt, pacjent))) {
                    najlepszyPunkt = punkt;
                }
            }
        }

        return najlepszyPunkt;
    }
}