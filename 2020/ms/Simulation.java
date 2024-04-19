import javax.lang.model.type.NullType;

public class Simulation {
    private final int _duration;

    private final Antibody _antibody;

    private final Virus _virus;

    public Simulation(int durationInMonths, Virus virus, Vaccine vaccine){
        _duration=durationInMonths;
        _virus=virus;
        _antibody = new Antibody(vaccine.getNucleotideChain());
    }

    public boolean runSimulation(){
        for(int month = 1; month<=_duration; month++){
            _virus.mutate();
        }
        return _antibody.doesRecogniseVirus(_virus);
    }
}
