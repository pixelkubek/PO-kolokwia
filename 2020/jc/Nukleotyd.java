public class Nukleotyd {
    private String typ;

    public Nukleotyd(String typ) {
        this.typ =typ;
    }

    public String getTyp() {return typ;}

    public boolean rowny(Nukleotyd inny) {
        return this.typ == inny.typ;
    }
}
