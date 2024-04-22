public class Ręka {
    private int _rozmiar = 5;
    private int kartNaRęce;
    private Karta[] ręka;
    
    public Ręka() {
        this.kartNaRęce = 0;
        this.ręka = new Karta[_rozmiar];
    }

    @Override
    public String toString() {
        String s = "";
        
        for (Karta karta : ręka)
            s+= karta + " ";

        return s;
    }

    public void dodajKartę(Karta karta) {
        this.ręka[kartNaRęce] = karta;
        kartNaRęce++;
    }

    public void opróżnijRękę() {
        kartNaRęce = 0;
    }

    public Karta maksymalnaKarta() {
        Karta maksymalnaKarta = null;

        for(int i = 0; i<ręka.length; i++)
            if(maksymalnaKarta == null || ręka[i].większaNiż(maksymalnaKarta))
                maksymalnaKarta =  ręka[i];

        return maksymalnaKarta;
    }
}
