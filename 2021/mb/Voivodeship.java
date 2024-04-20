public class Voivodeship {
    private VaccinationOffice[] vaccinationOffices;
    private int id;
    private String name;

    public Voivodeship(int id, String name, VaccinationOffice[] vaccinationOffices) {
        this.id = id;
        this.name = name;
        this.vaccinationOffices = vaccinationOffices;
    }

    public VaccinationOffice findBestVaccinationOffice(Patient patient, int maxDistance, Vaccine vaccine) {
        VaccinationOffice currentOffice = null;

        //Go through every vaccination office and find the best one
        for (VaccinationOffice office : vaccinationOffices) {
            // Skip if office doesn't meet criteria
            if(office.getOfferedVaccine() != vaccine || PostCodeHelper.distance(patient, office) > maxDistance)
                continue;

            // Check if it is bette than the current one
            if(betterThanCurrentOffice(currentOffice, office, patient))
                currentOffice = office;
        }

        return currentOffice;
    }

    private boolean betterThanCurrentOffice(VaccinationOffice currentOffice, VaccinationOffice newOffice, Patient patient) {
        if(currentOffice == null) return true;

        if(newOffice.getNextFreeDay() < currentOffice.getNextFreeDay()) return true;

        return newOffice.getNextFreeDay() == currentOffice.getNextFreeDay() &&
                PostCodeHelper.distance(patient, newOffice) < PostCodeHelper.distance(patient, currentOffice);
    }
}
