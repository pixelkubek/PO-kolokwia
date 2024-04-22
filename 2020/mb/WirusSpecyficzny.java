import java.util.Random;

public class WirusSpecyficzny extends Wirus {
    private int[] miejscaMutacji;    
    private Nukleotyd[] możliweMutacje;    

    public WirusSpecyficzny(int częstotliwośćMutacji, KwasNukleinowy kwasNukleinowy, int[] miejscaMutacji, Nukleotyd[] możliweMutacje) {
        super(częstotliwośćMutacji, kwasNukleinowy);
        this.miejscaMutacji = miejscaMutacji;
        this.możliweMutacje = możliweMutacje;
    }

    public void mutuj() {
        Random r = new Random();

        int pozycja = miejscaMutacji[r.nextInt(miejscaMutacji.length)];
        Nukleotyd obecnyNukleotyd = kwasNukleinowy.dajNukleotyd(pozycja);
        Nukleotyd nowyNukleotyd;

        do {
            nowyNukleotyd = możliweMutacje[r.nextInt(możliweMutacje.length)];
        } while(obecnyNukleotyd.takiSam(nowyNukleotyd));

        kwasNukleinowy.zmieńNukleotyd(pozycja, nowyNukleotyd);
    }
}