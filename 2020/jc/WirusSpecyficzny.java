import java.util.ArrayList;
import java.util.Random;

public class WirusSpecyficzny extends Wirus {
    private int[] mutujacePozycje;
    private Nukleotyd[] dopuszczoneNukleotydy;

    public WirusSpecyficzny(KwasNukleinowy kwas, int liczbaMutacji, int[] mutujacePozycje, Nukleotyd[] dopuszczoneNukleotydy) {
        this.kwasWirusa = kwas;
        this.liczbaMutacjiMieisac = liczbaMutacji;
        this.mutujacePozycje = mutujacePozycje;
        this.dopuszczoneNukleotydy = dopuszczoneNukleotydy;
    }

    @Override
    public void mutuj() {
        Random r = new Random();
        int n = r.nextInt(mutujacePozycje.length);
        int mutowanaPozycja = mutujacePozycje[n];

        ArrayList<Nukleotyd> mozliweNukleotydy = new ArrayList<Nukleotyd>();

        for(Nukleotyd s : dopuszczoneNukleotydy) {
            if(!s.rowny(kwasWirusa.getKod()[mutowanaPozycja])) {
                mozliweNukleotydy.add(s);
            }
        }

        int idxNowego = r.nextInt(mozliweNukleotydy.size());
        kwasWirusa.getKod()[mutowanaPozycja] = mozliweNukleotydy.get(idxNowego);
    }
}
