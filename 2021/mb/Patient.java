public class Patient {
    private String PESEL;

    private int postCode;

    public Patient(String PESEL, int postCode) {
        this.PESEL = PESEL;
        this.postCode = postCode;
    }

    public String getPESEL() {
        return PESEL;
    }
    public int getPostCode() {
        return postCode;
    }
}
