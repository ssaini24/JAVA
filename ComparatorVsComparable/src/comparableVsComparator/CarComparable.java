package comparableVsComparator;

public class CarComparable implements  Comparable<CarComparable> {
    private String name;
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CarComparable(String name, String type){
        this.name = name;
        this.type = type;
    }

    // need to use this so cannot move it into another new class like comparator
    @Override
    public int compareTo(CarComparable o) {
        return this.type.compareTo(o.type);
    }
}
