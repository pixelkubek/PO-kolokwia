public class SymulacjaSystemuOdpornosciowego {
    private Przeciwcialo przeciwcialo;
    private Wirus wirus;

    public SymulacjaSystemuOdpornosciowego(Szczepionka szczepionka, Wirus wirus) {
        przeciwcialo = szczepionka.tworzonePrzeciwcialo();
        this.wirus = wirus;
    }

    private void symulujMiesiac() {
        for(int i = 0; i < wirus.getLiczbaMutacji(); i++)
            wirus.mutuj();
    }

    private void symulujMiesiace(int liczbaMiesiecy) {
        for(int i = 0; i < liczbaMiesiecy; i++)
            this.symulujMiesiac();
    }

    public boolean ochroniPoSymulacji(int liczbaMiesiecy) {
        symulujMiesiace(liczbaMiesiecy);
        return przeciwcialo.eliminujeWirusa(wirus);
    }
}
