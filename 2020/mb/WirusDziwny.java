import java.util.Random;

public class WirusDziwny extends Wirus {
     
    public WirusDziwny(int częstotliwośćMutacji, KwasNukleinowy kwasNukleinowy) {
        super(częstotliwośćMutacji, kwasNukleinowy);
    }

    public void mutuj() {
        Random r = new Random();
        int rozmiar = kwasNukleinowy.dajRozmiarKwasu();

        int poz1 = r.nextInt(rozmiar);
        int poz2 = r.nextInt(rozmiar);

        // Zamieniamy dwa nukleotydy z sobą
        Nukleotyd tmp = kwasNukleinowy.dajNukleotyd(poz1);
        kwasNukleinowy.zmieńNukleotyd(poz1, kwasNukleinowy.dajNukleotyd(poz2));
        kwasNukleinowy.zmieńNukleotyd(poz2, tmp);
    }
}