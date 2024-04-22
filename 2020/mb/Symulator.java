public class Symulator {
    public static boolean symuluj(Szczepionka szczepionka, Wirus wirus, int ileMiesięcy) {
        Przeciwciała przeciwciała = new Przeciwciała(szczepionka);

        for(int i = 0 ; i < ileMiesięcy; i++)
            for(int j = 0; j < wirus.dajCzęstotliwośćMutacji(); i++)
                wirus.mutuj();

        return przeciwciała.czyZwalczają(wirus);
    }
}