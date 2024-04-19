public abstract class Virus {
    protected Nucleotide[] _nucleotideCode;

    protected final int _mutationsPerMonthCount;

    public Virus(Nucleotide[] nucleotideCode, int mutationsPerMonthCount){
        _nucleotideCode = new Nucleotide[nucleotideCode.length];
        System.arraycopy(nucleotideCode,0, _nucleotideCode, 0, nucleotideCode.length);
        _mutationsPerMonthCount = mutationsPerMonthCount;
    }

    public void mutate(){
        for(int i = 1; i<_mutationsPerMonthCount; i++){
            mutateOnce();
        }
    }

    protected abstract void mutateOnce();

    public final Nucleotide[] getNucleotideCode(){
        Nucleotide[] nucleotides = new Nucleotide[_nucleotideCode.length];
        System.arraycopy(_nucleotideCode,0, nucleotides, 0, _nucleotideCode.length);
        return nucleotides;
    }
}
