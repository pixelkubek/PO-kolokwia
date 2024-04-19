import java.util.ArrayList;
import java.util.List;

public class SimpleVaccinationRegistry implements IVaccinationRegistry {
    private final List<Patient> _vaccinatedPatients;

    public SimpleVaccinationRegistry(){
        _vaccinatedPatients = new ArrayList<Patient>();
    }

    @Override
    public void reportVaccinated(Patient patient) {
        _vaccinatedPatients.add(patient);
    }

    public Patient[] getVaccinatedPatients(){
        return _vaccinatedPatients.toArray(Patient[]::new);
    }
}
