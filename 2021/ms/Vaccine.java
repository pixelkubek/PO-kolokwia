public class Vaccine {
    private final String _name;

    private final String _manufacturerName;

    private final int _doseSizeInMl;

    public Vaccine(String name, String manufacturerName, int doseSizeInMl){
        _name=name;
        _manufacturerName=manufacturerName;
        _doseSizeInMl=doseSizeInMl;
    }

    public String getName(){
        return _name;
    }

    public String getManufacturerName(){
        return _manufacturerName;
    }

    public int getDoseSizeInMl(){
        return _doseSizeInMl;
    }
}
