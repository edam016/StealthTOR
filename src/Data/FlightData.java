package Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import Components.Flight;

public class FlightData {
    private static FlightData instance;
    private List<Components.Flight> flightData;

    public FlightData() {
        flightData = new ArrayList();
    }

    public static FlightData getInstance() {
        if (instance == null) {
            instance = new FlightData();
        }
        return instance;
    }

    public void initialize(List<Flight> data) {
        if (flightData.isEmpty()) {
            flightData.addAll(data);
        } else {
            System.out.println("Flight data already initialized.");
        }
    }

    public List<Components.Flight> getFlightData() {
        return flightData;
    }
}