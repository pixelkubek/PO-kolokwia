public class Antibody {
    private final Nucleotide[] _nucleotideChain;

    public Antibody(Nucleotide[] nucleotideChain){
        _nucleotideChain = new Nucleotide[nucleotideChain.length];
        System.arraycopy(nucleotideChain,0,_nucleotideChain,0,nucleotideChain.length);
    }

    public Nucleotide[] getNucleotideChain(){
        Nucleotide[] chain = new Nucleotide[_nucleotideChain.length];
        System.arraycopy(_nucleotideChain,0,chain,0,_nucleotideChain.length);
        return chain;
    }

    public boolean doesRecogniseVirus(Virus virus){
        return doesIncludeIn(virus.getNucleotideCode(), _nucleotideChain);
    }

    private boolean doesIncludeIn(Nucleotide[] chain, Nucleotide[] subChain){
        int j = 0;
        for (Nucleotide nucleotide : chain) {
            if (nucleotide == subChain[j]) {
                j++;
                if (j == subChain.length - 1)
                    return true;
            } else
                j = 0;
        }
        return false;
    }
}
