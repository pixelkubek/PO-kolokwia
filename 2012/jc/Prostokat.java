package jc;

public class Prostokat {
    private Punkt lewyDolny, prawyGorny;

    public Prostokat(Punkt lewyDolny, Punkt prawyGorny) {
        this.lewyDolny = lewyDolny;
        this.prawyGorny = prawyGorny;
    }

    public Prostokat(int x1, int y1, int x2, int y2) {
        this(new Punkt(x1, y1), new Punkt(x2, y2));
    }

    private boolean pusty() {
        return lewyDolny.getX() > prawyGorny.getX() ||
                lewyDolny.getY() > prawyGorny.getY();
    }

    public boolean porownaj(Prostokat prostokat) {
        // Równoważne wtw mają taki sam zbiór punktów.
        if(this.pusty() && prostokat.pusty()) {
            return true;
        } else {
            return this.lewyDolny.rowny(prostokat.lewyDolny) &&
                    this.prawyGorny.rowny(prostokat.prawyGorny);
        }
    }

    public boolean zawiera(Punkt punkt) {
        return !pusty() && punkt.pomiedzy(lewyDolny, prawyGorny);
    }

    public boolean wewnatrz(Prostokat prostokat) {
        if(this.pusty()) {
            return true;
        } else if(!this.pusty() && !prostokat.pusty()) {
            return this.lewyDolny.pomiedzy(prostokat.lewyDolny, prostokat.prawyGorny) &&
                    this.prawyGorny.pomiedzy(prostokat.lewyDolny, prostokat.prawyGorny);
        } else {
            return false;
        }
    }
}
