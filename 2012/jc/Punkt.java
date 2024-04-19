package jc;

public class Punkt {
    private int x, y;

    public Punkt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {return x;}
    public int getY() {return y;}

    public boolean rowny(Punkt punkt) {
        return this.x == punkt.x && this.y == punkt.y;
    }

    // Ściśle między lub równy.
    public boolean pomiedzy(Punkt punkt1, Punkt punkt2) {
        return this.x >= Math.min(punkt1.x, punkt2.x) &&
                this.x <= Math.max(punkt1.x, punkt2.x) &&
                this.y >= Math.min(punkt1.y, punkt2.y) &&
                this.y <= Math.max(punkt1.y, punkt2.y);
    }
}
