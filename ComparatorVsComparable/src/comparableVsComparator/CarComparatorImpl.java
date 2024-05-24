package comparableVsComparator;

import java.util.Comparator;

public class CarComparatorImpl implements Comparator<CarComparator> {
    @Override
    public int compare(CarComparator o1, CarComparator o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
