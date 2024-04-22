public class Talia {
    private Karta[] karty;
    private int kartyRozdane;

    public Talia() {
        karty = new Karta[52];
        kartyRozdane = 0;

        // for (int wartosc = 0; wartosc < 13; wartosc++) {
        //     for (int kolor = 0; kolor < 4; kolor++) {
        //         karty[4 * wartosc + kolor] = new Karta(Karta.Wartość.values()[wartosc],Karta.Kolor.values()[kolor]);
        //     }
        // }    
        
        int i = 0;
        for (Karta.Wartość wartość : Karta.Wartość.values()) {
            for (Karta.Kolor kolor : Karta.Kolor.values()) {
                karty[i++] = new Karta(wartość, kolor);
            }
        }     
    }

    private void przemieńKarty() {
        Karta[] noweUłożenie = new Karta[52];

        for (int i = 0; i < 52/2; i++) {
            noweUłożenie[2 * i] = karty[51 - i]; 
            noweUłożenie[2 * i + 1] = karty[25 - i]; 
        }

        karty = noweUłożenie;
    }

    private void przełóżKarty() {
        Karta[] noweUłożenie = new Karta[52];

        int punktPodziału = (int)Math.floor(Math.random() * 51) + 1;
        
        for(int i = punktPodziału; i < 52; i++)
            noweUłożenie[i - punktPodziału] = karty[i];

        for(int i = 0; i < punktPodziału; i++)
            noweUłożenie[i + 52 - punktPodziału] = karty[i];

        karty = noweUłożenie;
    }

    public void tasuj() {
        for (int i = 0; i < 5; i++) {
            przemieńKarty();
            przełóżKarty();
        }
    }

    public Karta dajKarteZGóry() {
        return karty[52 - ++kartyRozdane];
    }
}
