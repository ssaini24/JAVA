import wildCards.Bus;
import wildCards.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class WildCardsAction {

    public static void setValue(List<? extends  Vehicle> list){

    }

    public static void wildCardsImpl(){
        List<Vehicle> vehicles = new ArrayList<>();

        List<Bus> buses = new ArrayList<>();

        // Below statement will give error without wildcards
        //  buses = vehicles;
        //  vehicles = buses;
        setValue(buses);
        setValue(vehicles);
    }
}
