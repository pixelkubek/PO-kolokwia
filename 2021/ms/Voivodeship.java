import java.util.Arrays;

public class Voivodeship {
    public final int MAX_DAY_NO = 365;

    private final String _name;

    private final int _id;

    private final VaccinationPoint[] _vaccinationPoints;

    public Voivodeship(int id, String name, VaccinationPoint[] vaccinationPoints) {
        if (vaccinationPoints.length == 0) {
            throw new IllegalArgumentException("Array of vaccination points cannot be empty.");
        }
        if (id < 0 || id > 9) {
            throw new IllegalArgumentException("Id must be a digit.");
        }
        _id = id;
        _name = name;
        _vaccinationPoints = new VaccinationPoint[vaccinationPoints.length];
        System.arraycopy(vaccinationPoints, 0, _vaccinationPoints, 0, vaccinationPoints.length);
    }

    public String getName() {
        return _name;
    }

    public int getId() {
        return _id;
    }

    public void planVisit(Patient patient) {
        VaccinationPoint[] vaccinationPoints = getPointsMatchingVisitRequirements(patient);
        if (vaccinationPoints.length == 0) {
            throw new IllegalStateException("Vaccination point with provided requirements foes not exist.");
        }

        int earliestVisitDayNo = MAX_DAY_NO + 1;
        int shortestDistance = patient.getMaxDistance();

        VaccinationPoint bestVaccinationPoint = vaccinationPoints[0];
        // Let: such day exists, otherwise we need to check.
        for (VaccinationPoint vaccinationPoint : vaccinationPoints) {
            if (isPointABetterMatch(earliestVisitDayNo, shortestDistance, patient.getAddress(), vaccinationPoint)) {
                earliestVisitDayNo = vaccinationPoint.getClosestAvailableDayNo();
                bestVaccinationPoint = vaccinationPoint;
                shortestDistance = AddressHelper.CalculateDistance(patient.getAddress(), vaccinationPoint);
            }
        }

        patient.setVisit(bestVaccinationPoint.registerVisit());
    }

    private VaccinationPoint[] getPointsMatchingVisitRequirements(Patient patient) {
        return Arrays.stream(_vaccinationPoints).filter(vaccinationPoint -> {
            if (vaccinationPoint.getVaccine() != patient.getVaccine())
                return false;
            return AddressHelper.CalculateDistance(patient, vaccinationPoint) <= patient.getMaxDistance();
        }).toArray(VaccinationPoint[]::new);
        // Solution 2: iterating first time to find number of elements, then copy them to array
        // Solution 3: use list and iterate once
    }

    private boolean isPointABetterMatch(int currentEarliestDay, int currentShortestDistance, int patientAddress, VaccinationPoint vaccinationPoint) {
        if (vaccinationPoint.getClosestAvailableDayNo() > currentEarliestDay) {
            return false;
        }
        if (vaccinationPoint.getClosestAvailableDayNo() < currentEarliestDay) {
            return true;
        }
        return AddressHelper.CalculateDistance(patientAddress, vaccinationPoint.getAddress()) < currentShortestDistance;
    }
}
