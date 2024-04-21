import java.util.Random;

public class WirusDziwny extends Wirus {
    public WirusDziwny(KwasNukleinowy kwas, int liczbaMutacji) {
        this.kwasWirusa = kwas;
        this.liczbaMutacjiMieisac = liczbaMutacji;
    }

    @Override
    public void mutuj() {
        Random r = new Random();
        int i1 = r.nextInt(kwasWirusa.getKod().length - 1);
        int i2 = r.nextInt(kwasWirusa.getKod().length - i1 - 1) + i1 + 1;

        Nukleotyd temp = kwasWirusa.getKod()[i1];
        kwasWirusa.getKod()[i1] = kwasWirusa.getKod()[i2];
        kwasWirusa.getKod()[i2] = temp;
    }
}
