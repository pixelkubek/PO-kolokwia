import java.util.Random;

public class SpecificVirus extends Virus{
    private final int[] _indexesForMutations;

    private final Nucleotide[] _possibleNucleotidesAfterMutation;

    private final Random _random;

    public SpecificVirus(Nucleotide[] nucleotideCode, int mutationsPerMonth, int[] indexesOfPossibleNucleotideMutations, Nucleotide[] possibleNucleotideAfterMutation){
        super(nucleotideCode, mutationsPerMonth);

        _indexesForMutations = new int[indexesOfPossibleNucleotideMutations.length];
        System.arraycopy(indexesOfPossibleNucleotideMutations,0, _indexesForMutations,0, indexesOfPossibleNucleotideMutations.length);

        _possibleNucleotidesAfterMutation = new Nucleotide[possibleNucleotideAfterMutation.length];
        System.arraycopy(possibleNucleotideAfterMutation, 0, _possibleNucleotidesAfterMutation, 0, possibleNucleotideAfterMutation.length);

        _random = new Random();
    }

    @Override
    protected void mutateOnce() {
        int mutationIndex = _indexesForMutations[_random.nextInt(_indexesForMutations.length)];

        Nucleotide mutatedNucleotide = _nucleotideCode[mutationIndex];
        do{
            mutatedNucleotide = _possibleNucleotidesAfterMutation[_random.nextInt(_possibleNucleotidesAfterMutation.length)];
        }while(mutatedNucleotide == _nucleotideCode[mutationIndex]);

        _nucleotideCode[mutationIndex] = mutatedNucleotide;
    }

    private int getNucleotideCodeLength(){
        return _nucleotideCode.length;
    }
}
