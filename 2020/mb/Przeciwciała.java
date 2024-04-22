public class Przeciwciała {
    private KwasNukleinowy coZwalczają;

    public Przeciwciała(Szczepionka szczepionka) {
        this.coZwalczają = szczepionka.dajNaCoUodpornia();
    }

    public boolean czyZwalczają(Wirus wirus) {
        KwasNukleinowy kwasWirusa = wirus.dajKwasNukleinowy();

        // Sprawdźmy czy kwas zawiera spójny podciąg "coZwalczają"
        for(int i = 0; i < kwasWirusa.dajRozmiarKwasu() - coZwalczają.dajRozmiarKwasu() + 1; i++) {
            for(int j = 0; j < coZwalczają.dajRozmiarKwasu(); j ++) {
                if(!coZwalczają.dajNukleotyd(j).takiSam(kwasWirusa.dajNukleotyd(i + j))) 
                    break;

                // Znaleźliśmy taki sam spójny podciąg
                if(j == coZwalczają.dajRozmiarKwasu() - 1)
                    return true;
            }
        }

        return false;
    }
}