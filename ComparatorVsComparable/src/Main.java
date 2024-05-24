import comparableVsComparator.CarComparable;
import comparableVsComparator.CarComparator;
import comparableVsComparator.CarComparatorImpl;
import sun.awt.image.ImageWatched;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("*** Sorting using comparable");
        List<CarComparable> carList = new ArrayList<>();

        carList.add(new CarComparable("verna", "sedan"));
        carList.add(new CarComparable("tiago", "hatchBack"));

        // must give compareTo impl in CarComparable class only
        Collections.sort(carList);

        for (CarComparable car: carList){
            System.out.println(car.getType());
        }

        System.out.println("*** Sorting using comparator");
        List<CarComparator> carComparatorList = new ArrayList<>();
        carComparatorList.add(new CarComparator("verna", "sedan"));
        carComparatorList.add(new CarComparator("tiago", "hatchBack"));

        // can create n number of classes like CarComparatorImpl having diff sorting logic
        Collections.sort(carComparatorList, new CarComparatorImpl());

        for(CarComparator carComparator : carComparatorList){
            System.out.println(carComparator.getType());
        }

        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(1, 2);

        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(2, 10);
        linkedHashMap.forEach((Integer a, Integer b) -> System.out.println(String.valueOf(a + " " + b)));
    }
}