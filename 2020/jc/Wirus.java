public abstract class Wirus {
    protected KwasNukleinowy kwasWirusa;
    protected int liczbaMutacjiMieisac;

    public KwasNukleinowy getKwas() {return kwasWirusa;}
    public int getLiczbaMutacji() {return liczbaMutacjiMieisac;}

    public abstract void mutuj();
}
