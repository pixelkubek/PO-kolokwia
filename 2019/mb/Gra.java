public class Gra {
    private Gracz[] gracze;
    private int stawka;

    private int rundyŁącznie = 0;

    public Gra(Gracz[] gracze, int stawka) {
        this.gracze = gracze;
        this.stawka = stawka;
    }

    public void symuluj() {
        while (true) {
            for (Gracz gracz : gracze)
                if(gracz.zrezygnował()) 
                    return;

            grajRundę();
        }
    }

    private void grajRundę() {
        int pula = zbierzPieniądzeOdGraczy();

        Talia talia = new Talia();
        talia.tasuj();

        rozdajKartyGraczom(talia);

        Gracz zwycięzca = znajdźZwycięzce();
        zwycięzca.dajPieniądze(pula);

        for (Gracz gracz : gracze)
            gracz.dajRękę().opróżnijRękę();

        dajRaport(zwycięzca);
    }

    private void dajRaport(Gracz zwycięzca) {
        System.out.println("Rozdanie nr: " + ++rundyŁącznie);

        for (Gracz gracz : gracze)
            System.out.println(gracz);

        System.out.println("Zwycięzca: " + zwycięzca);
            
    }

    private Gracz znajdźZwycięzce() {
        // Szukamy maksymalną kartę wśród wszytkach kart graczy
        Karta maksymalnaKarta = null;
        Gracz maksymalnyGracz = null;

        for(int i = 0; i<gracze.length; i++) {
            if(maksymalnaKarta == null || gracze[i].dajRękę().maksymalnaKarta().większaNiż(maksymalnaKarta)){
                maksymalnaKarta = gracze[i].dajRękę().maksymalnaKarta();
                maksymalnyGracz = gracze[i];
            }
        }

        return maksymalnyGracz;
    }

    private void rozdajKartyGraczom(Talia talia) {
        for(int i =0; i<5; i++)
            for (Gracz gracz : gracze)
                gracz.dajRękę().dodajKartę(talia.dajKarteZGóry());
    }

    private int zbierzPieniądzeOdGraczy() {
        int pula = 0;
        for (Gracz gracz : gracze) {
            gracz.zabierzPieniądze(stawka);
            pula += stawka;
        }

        return pula;
    }
}
