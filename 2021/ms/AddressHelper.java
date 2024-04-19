class AddressHelper {
    public static int CalculateDistance(int addressA, int addressB){
        return Math.abs(addressA-addressB);
    }

    public static int CalculateDistance(int addressA, VaccinationPoint vaccinationPoint){
        return CalculateDistance(addressA, vaccinationPoint.getAddress());
    }

    public static int CalculateDistance(Patient patient, VaccinationPoint vaccinationPoint){
        return CalculateDistance(patient.getAddress(), vaccinationPoint.getAddress());
    }

    public static boolean isAddressValid(int address){
        return address >= 10000 && address <= 99999;
    }
}
