public class KwasNukleinowy {
    private Nukleotyd[] kod;
    private String typ;

    public KwasNukleinowy(Nukleotyd[] kod, String typ) {
        this.kod = kod;
        this.typ = typ;
    }

    public Nukleotyd[] getKod() {return kod;}
    public String getTyp() {return typ;}

    public boolean zawieraCiag(Nukleotyd[] ciag) {
        for (int i = 0; i < kod.length - ciag.length + 1; i++) {
            boolean rowne = true;
            for(int j = 0; j < ciag.length; j++) {
                if(!kod[i + j].rowny(ciag[j])) {
                    rowne = false;
                }
            }

            if(rowne) return true;
        }

        return false;
    }
}
