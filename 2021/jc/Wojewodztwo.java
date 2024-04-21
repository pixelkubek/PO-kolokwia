public class Wojewodztwo {
    private int cyfra;
    private PunktSzczepien[][] punktySzczepien; // punktySzczepien[adres][nr. punktu]

    public Wojewodztwo(int numer, PunktSzczepien[][] punktySzczepien) {
        this.cyfra = numer;
        this.punktySzczepien = punktySzczepien;
    }

    public PunktSzczepien wskazPunkt(Pacjent pacjent) {
        int najblizszyTermin = 366;
        PunktSzczepien punktZTerminem = null;

        int adresPacjentaWWojewodztwie = pacjent.getKodPocztowy() - pacjent.getWojewodztwo() * 10000;

        for(int odleglosc = 0; odleglosc <= pacjent.getOdleglosc(); odleglosc++) {
            for(int znak = -1; znak <= 1; znak++) {
                if(adresPacjentaWWojewodztwie + znak * odleglosc >= 0 && adresPacjentaWWojewodztwie + znak * odleglosc < 10000) {
                    for(PunktSzczepien punkt : punktySzczepien[adresPacjentaWWojewodztwie + znak * odleglosc]) {
                        if(punkt.poprawnaSzczepionka(pacjent)) {
                            if(punkt.getNajblizszyWolnyTermin() < najblizszyTermin) {
                                najblizszyTermin = punkt.getNajblizszyWolnyTermin();
                                punktZTerminem = punkt;
                            }
                        }
                    }
                }
            }
        }
        return punktZTerminem;
    }
}