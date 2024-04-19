public class Visit {
    private final int _dayNo;

    private final int _vaccinationPointAddress;

    public Visit(int dayNo, int vaccinationPointAddress){
        _dayNo = dayNo;
        _vaccinationPointAddress = vaccinationPointAddress;
    }

    public int getDayNo(){
        return _dayNo;
    }

    public int getVaccinationPointAddress(){
        return _vaccinationPointAddress;
    }
}
