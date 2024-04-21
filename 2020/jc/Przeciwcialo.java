public class Przeciwcialo {
    private Nukleotyd[] eliminowanyCiag;

    public Przeciwcialo(Nukleotyd[] ciag) {
        eliminowanyCiag = ciag;
    }

    public Nukleotyd[] getEliminowanyCiag() {return eliminowanyCiag;}

    public boolean eliminujeWirusa(Wirus wirus) {
        return wirus.getKwas().zawieraCiag(eliminowanyCiag);
    }
}
