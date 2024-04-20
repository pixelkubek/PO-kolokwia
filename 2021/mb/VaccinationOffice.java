public class VaccinationOffice {
    private CentralVaccinationOffice CVO;
    private Vaccine offeredVaccine;
    private int postCode;

    private int dailyThroughput;

    private int _nextFreeDay;
    private int _patientsThatDay;

    public VaccinationOffice(CentralVaccinationOffice CVO, Vaccine offeredVaccine, int postCode, int dailyThroughput) {
        this.CVO = CVO;
        this.offeredVaccine = offeredVaccine;
        this.postCode = postCode;
        this.dailyThroughput = dailyThroughput;

        this._nextFreeDay = 1;
        this._patientsThatDay = 0;
    }

    public int getPostCode() {
        return postCode;
    }

    public Vaccine getOfferedVaccine() {
        return offeredVaccine;
    }

    public int getNextFreeDay() {
        return _nextFreeDay;
    }

    // Registers the patient for a vaccination appointment and
    // returns the appointment date.
    public int makePatientAppointment() {
        int appointmentDate = getNextFreeDay();

        // Add one more patient to this day
        if(++_patientsThatDay == dailyThroughput) {
            // The day is full, move to next one

            _nextFreeDay++;
            _patientsThatDay = 0;
        }

        return appointmentDate;
    }

    public void vaccinatePatient(Patient patient) {
        CVO.registerVaccination(patient);
    }
}
