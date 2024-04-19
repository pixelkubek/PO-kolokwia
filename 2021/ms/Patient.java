public class Patient {
    private final int _address;

    private final int _maxDistance;

    private final Vaccine _demandedVaccine;

    private Visit _visit;

    public Patient(int address, int maxDistance, Vaccine demandedVaccine){
        if(AddressHelper.isAddressValid(address)){
            throw new IllegalArgumentException("Address must be a positive 5-digit integer.");
        }
        if(maxDistance<0){
            throw new IllegalArgumentException("Max distance must be a non-negative integer.");
        }
        _address=address;
        _maxDistance=maxDistance;
        _demandedVaccine=demandedVaccine;
    }

    public int getAddress(){
        return _address;
    }

    public int getMaxDistance(){
        return _maxDistance;
    }

    public Vaccine getVaccine(){
        return _demandedVaccine;
    }

    public Visit getVisit(){
        return _visit;
    }

    public void setVisit(Visit visit){
        _visit=visit;
    }
}
