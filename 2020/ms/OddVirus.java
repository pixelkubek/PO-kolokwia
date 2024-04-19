import java.util.Random;

public class OddVirus extends Virus{
    private final Random _random;

    public OddVirus(Nucleotide[] nucleotideCode, int mutationsPerMonth){
        super(nucleotideCode,mutationsPerMonth);

        _random = new Random();
    }

    @Override
    protected void mutateOnce() {
        int firstSwapIndex = _random.nextInt(getNucleotideCodeLength());
        int secondSwapIndex = firstSwapIndex;
        do{
            secondSwapIndex = _random.nextInt(getNucleotideCodeLength());
        }while(firstSwapIndex == secondSwapIndex);

        Nucleotide firstNucleotide = _nucleotideCode[firstSwapIndex];
        _nucleotideCode[firstSwapIndex]=_nucleotideCode[secondSwapIndex];
        _nucleotideCode[secondSwapIndex]=firstNucleotide;
    }

    private int getNucleotideCodeLength(){
        return _nucleotideCode.length;
    }
}
