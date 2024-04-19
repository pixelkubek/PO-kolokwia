import java.util.Arrays;

public class CentralVaccinationOffice {
    private final Voivodeship[] _voivodeships;

    private final IVaccinationRegistry _vaccinationRegistry;
    
    public CentralVaccinationOffice(Voivodeship[] voivodeships, IVaccinationRegistry vaccinationRegister){
        if(voivodeships.length == 0){
            throw new IllegalArgumentException("Array of voivodeships cannot be empty.");
        }
        _voivodeships = new Voivodeship[voivodeships.length];
        System.arraycopy(voivodeships, 0, _voivodeships, 0, voivodeships.length);
        _vaccinationRegistry = vaccinationRegister;
    }

    public void registerVisit(Patient patient){
        int voivodeshipNo = Integer.parseInt(Integer.toString(patient.getAddress()).substring(0, 1));
        Voivodeship voivodeship = Arrays.stream(_voivodeships).filter((x)->{return x.getId() == voivodeshipNo;}).findFirst().get();
        voivodeship.planVisit(patient);
    }

    public Patient[] getVaccinatedPatients(){
        return _vaccinationRegistry.getVaccinatedPatients();
    }
}
