public class Vaccine {
    private final Nucleotide[] _nucleotideChain;

    public Vaccine(Nucleotide[] nucleotideChain){
        _nucleotideChain = new Nucleotide[nucleotideChain.length];
        System.arraycopy(nucleotideChain,0,_nucleotideChain,0,nucleotideChain.length);
    }

    public Nucleotide[] getNucleotideChain(){
        Nucleotide[] chain = new Nucleotide[_nucleotideChain.length];
        System.arraycopy(_nucleotideChain,0,chain,0,_nucleotideChain.length);
        return chain;
    }
}
