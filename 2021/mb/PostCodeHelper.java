public class PostCodeHelper {
    public static int extractVoivodeshipId(int postCode) {
        return postCode/10000;
    }

    public static int distance(int a, int b) {
        return Math.abs(a-b);
    }

    public static int distance(Patient p, VaccinationOffice o) {
        return distance(p.getPostCode(), o.getPostCode());
    }
}
