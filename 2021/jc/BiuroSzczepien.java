public class BiuroSzczepien {
    private Wojewodztwo[] wojewodztwa;

    public BiuroSzczepien(Wojewodztwo[] wojewodztwa) {
        this.wojewodztwa = wojewodztwa;
    }

    public PunktSzczepien wskazPunkt(Pacjent pacjent) {
        return wojewodztwa[pacjent.getKodPocztowy().getWojewodztwo()].wskazPunkt(pacjent);
    }
}