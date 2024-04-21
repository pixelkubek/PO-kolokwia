public class Gra {
    private Talia talia;
    private Gracz[] gracze;
    private int stawka, runda;

    public Gra(Gracz[] gracze, int stawka) {
        this.gracze = gracze;
        this.stawka = stawka;
        this.talia = new Talia();
        this.runda = 1;
    }

    private void rozdajKarty() {
        for(int i = 0; i < 5; i++) {
            for(Gracz g : gracze) {
                g.dodajKarte(talia.popSzczyt());
            }
        }
    }

    private Gracz znajdzZwyciezce() {
        Gracz wynik = gracze[0];
        for(Gracz g : gracze) {
            if(g.najstarszaKarta().wiekszaNiz(wynik.najstarszaKarta())) {
                wynik = g;
            }
        }

        return wynik;
    }

    private void symulujIRaportujRunde() {
        System.out.println(runda++);

        talia = new Talia();

        for(Gracz g : gracze)
            g.odejmijPieniadze(stawka);

        talia.tasuj();
        rozdajKarty();

        for(Gracz g : gracze)
            System.out.println(g + " " + g.getReka());

        Gracz zwyciezca = znajdzZwyciezce();

        System.out.println("zwyciezca: " + zwyciezca);

        zwyciezca.dodajPieniadze(stawka * gracze.length);

        for(Gracz g : gracze)
            g.nowaReka();
    }

    private boolean wszyscyMogaGrac() {
        for(Gracz g : gracze) {
            if(!g.mozeGrac(stawka) || g.dobrowolnieRezygnuje()) {
                return false;
            }
        }

        return true;
    }

    public void symuluj() {
        while(wszyscyMogaGrac()) {
            symulujIRaportujRunde();
        }
    }
}
