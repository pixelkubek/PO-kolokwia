public class Szczepionka {
    private Nukleotyd[] eliminowanyCiag;

    public Szczepionka(Nukleotyd[] eliminowanyCiag) {
        this.eliminowanyCiag = eliminowanyCiag;
    }

    public Przeciwcialo tworzonePrzeciwcialo() {
        return new Przeciwcialo(eliminowanyCiag);
    }
}
