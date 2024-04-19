import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
    static final int SEQUENCE_LENGTH = 12;
    static final int SIMULATION_LENGTH = 13;

    static final int MUTATIONS_PER_MONTH=20;

    public static void main(String[] args){
        Test1();
        Test2();
    }

    private static void Test1(){
        System.out.println("Test no. 1");
        Virus virus = new OddVirus(generateRandomSequence(SEQUENCE_LENGTH), MUTATIONS_PER_MONTH);
        System.out.println("Nucleotide sequence on start: "+ Arrays.toString(virus.getNucleotideCode()));
        Vaccine vaccine = new Vaccine(Arrays.stream(virus.getNucleotideCode()).skip(virus.getNucleotideCode().length-3).toArray(Nucleotide[]::new));
        System.out.println("Vaccine sequence: "+ Arrays.toString(vaccine.getNucleotideChain()));
        Simulation simulation = new Simulation(SIMULATION_LENGTH, virus, vaccine);

        if(simulation.runSimulation()){
            System.out.println("Patient wins!");
        }
        else{
            System.out.println("Patient died.");
        }

        System.out.println("Nucleotide sequence after permutations: "+ Arrays.toString(virus.getNucleotideCode()));

        System.out.println();
    }

    private static void Test2(){
        final Nucleotide[] possibleNucleotidesForMutations = new Nucleotide[] {Nucleotide.A, Nucleotide.C, Nucleotide.T};
        System.out.println("Test no. 2");
        Nucleotide[] sequence = generateRandomSequence(10);
        int[] indexesToMutate = getRandomIndexes(sequence.length);

        System.out.printf("Indexes: %s%n", Arrays.toString(indexesToMutate));
        System.out.printf("Nucleotides for mutations: %s%n", Arrays.toString(possibleNucleotidesForMutations));

        Virus virus = new SpecificVirus(sequence, 20, indexesToMutate, possibleNucleotidesForMutations);
        System.out.println("Nucleotide sequence on start: "+ Arrays.toString(virus.getNucleotideCode()));
        Vaccine vaccine = new Vaccine(Arrays.stream(virus.getNucleotideCode()).skip(virus.getNucleotideCode().length-3).toArray(Nucleotide[]::new));
        System.out.println("Vaccine sequence: "+ Arrays.toString(vaccine.getNucleotideChain()));
        Simulation simulation = new Simulation(13, virus, vaccine);

        if(simulation.runSimulation()){
            System.out.println("Patient wins!");
        }
        else{
            System.out.println("Patient died.");
        }

        System.out.println("Nucleotide sequence after permutations: "+ Arrays.toString(virus.getNucleotideCode()));

        System.out.println();
    }

    private static Nucleotide[] generateRandomSequence(int size){
        final Nucleotide[] choices = new Nucleotide[]{Nucleotide.A, Nucleotide.T, Nucleotide.G, Nucleotide.C};
        Nucleotide[] randomSequence = new Nucleotide[size];
        Random random = new Random();
        for(int i = 0; i<size; i++){
            randomSequence[i] = choices[random.nextInt(choices.length)];
        }
        return randomSequence;
    }

    private static int[] getRandomIndexes(int limit){
        Random random = new Random();
        List<Integer> indexes = new ArrayList<Integer>();
        int firstOne = random.nextInt(limit);
        indexes.add(firstOne);
        for(int i = 0; i<limit; i++){
            if(i==firstOne)
                continue;
            if(random.nextBoolean())
                indexes.add(i);
        }
        return indexes.stream().mapToInt((x)->x).toArray();
    }

}
