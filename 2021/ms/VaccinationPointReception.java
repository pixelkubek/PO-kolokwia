class VaccinationPointReception implements IRegistrationHandler{

    private final int _throughputPerDay;
    private int _closestAvailableDayNo;
    private int _closestAvailableDayVisitsCount;

    public VaccinationPointReception(int throughputPerDay){
        if(throughputPerDay <=0){
            throw new IllegalArgumentException("Throughput must be a positive integer.");
        }
        _throughputPerDay = throughputPerDay;

        _closestAvailableDayNo=0;
        _closestAvailableDayVisitsCount=0;
    }

    @Override
    public int registerVisit() {
        _closestAvailableDayVisitsCount ++;
        int visitDayNo = _closestAvailableDayNo;

        if(_closestAvailableDayVisitsCount == _throughputPerDay){
            _closestAvailableDayNo++;
            _closestAvailableDayVisitsCount = 0;
        }
        return visitDayNo;
    }

    @Override
    public int getClosestAvailableDayNo(){
        return _closestAvailableDayNo;
    }
}
