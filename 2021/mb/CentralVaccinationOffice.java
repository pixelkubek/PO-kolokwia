import java.util.ArrayList;
import java.util.List;

public class CentralVaccinationOffice {
    private List<Patient> vaccinatedPatients;
    private Voivodeship[] voivodeships;

    public  CentralVaccinationOffice(Voivodeship[] voivodeships) {
        this.voivodeships = voivodeships; // voivodeships with id = i should be at index i
        this.vaccinatedPatients = new ArrayList<Patient>();
    }

    public VaccinationOffice findBestVaccinationOffice(Patient patient, int maxDistance, Vaccine vaccine) {
        int voivodeshipId = PostCodeHelper.extractVoivodeshipId(patient.getPostCode());
        return voivodeships[voivodeshipId].findBestVaccinationOffice(patient, maxDistance, vaccine);
    }

    public void registerVaccination(Patient patient) {
        vaccinatedPatients.add(patient);
    }
}
