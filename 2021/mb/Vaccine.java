public class Vaccine {
    private String name;
    private String manufacturer;
    private String dose;

    public Vaccine(String name, String manufacturer, String dose) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.dose = dose;
    }

    public String getDose() {
        return dose;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getName() {
        return name;
    }
}
