public interface IVaccinationRegistry {
    void reportVaccinated(Patient patient);

    Patient[] getVaccinatedPatients();
}
