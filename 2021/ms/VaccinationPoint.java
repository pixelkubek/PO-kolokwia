public class VaccinationPoint {
    private int _address;

    private final Vaccine _vaccine;

    private final int _throughputPerDay;

    private final IRegistrationHandler _reception;

    private final IVaccinationRegistry _vaccinationRegister;

    public VaccinationPoint(int address, Vaccine vaccine, int throughputPerDay, IVaccinationRegistry vaccinationRegister){
        if(AddressHelper.isAddressValid(address))
            throw new IllegalArgumentException("Address must be a five digit number.");

        _vaccine=vaccine;
        if(throughputPerDay <= 0)
            throw new IllegalArgumentException("Throughput must be a positive integer.");
        _throughputPerDay = throughputPerDay;

        _reception = new VaccinationPointReception(_throughputPerDay);
        _vaccinationRegister = vaccinationRegister;
    }

    public Vaccine getVaccine() {
        return _vaccine;
    }

    public int getThroughputPerDay(){
        return _throughputPerDay;
    }

    public int getClosestAvailableDayNo(){
        return _reception.getClosestAvailableDayNo();
    }

    public Visit registerVisit(){

        int dayNo = _reception.registerVisit();
        return new Visit(dayNo, _address);
    }

    public int getAddress(){
        return _address;
    }

    public void giveVaccine(Patient patient){
        _vaccinationRegister.reportVaccinated(patient);
    }
}
