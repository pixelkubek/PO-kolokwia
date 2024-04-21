import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] dziedziny = new int[][]{
          new int[]{1,2,3},
          new int[]{1,2,3}
        };
        int[][] przeciwdziedziny = new int[][]{
                new int[]{1,2,2},
                new int[]{3,1,1}
        };
        Funkcja[] funkcje = new Funkcja[dziedziny.length];
        for(int i = 0; i<dziedziny.length; i++){
            funkcje[i] = new FunkcjaTablicowa(dziedziny[i], przeciwdziedziny[i]);
            testFunction(funkcje[i], dziedziny[i], przeciwdziedziny[i]);
            System.out.println();
        }

        Metryka pierwsza = new EarthMover();
        System.out.println("Earth mover: "+pierwsza.obliczOdleglosc(funkcje[0], funkcje[1]));

        Metryka druga = new HammingDistance();
        System.out.println("Hamming distance: "+druga.obliczOdleglosc(funkcje[0], funkcje[1]));
    }

    private static void testFunction(Funkcja f, int[] dziedzina, int[] przeciwdziedzina){
        System.out.println("Sprawdzanie dziedziny...");
        if(Arrays.equals(f.odczytajDziedzine(), dziedzina)){
            System.out.println("Te same.");
        }
        else{
            System.out.println("Różnią się");
        }

        System.out.println("Sprawdzanie przeciwdziedziny...");
        if(Arrays.equals(f.odczytajPrzeciwdziedzine(), przeciwdziedzina)){
            System.out.println("Te same.");
        }
        else{
            System.out.println("Różnią się");
        }

        for(int i = 0; i<dziedzina.length; i++){
            System.out.println("Sprawdzanie wartości dla x="+dziedzina[i]);
            if(f.aplikuj(dziedzina[i]) == przeciwdziedzina[i]){
                System.out.println("Działa.");
            }
            else{
                System.out.println("Nie działa.");
            }
        }
    }
}