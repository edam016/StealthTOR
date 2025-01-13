package Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Components.Airplane;
import Components.Order;
import Data.FlightData;

public class Datapopulation {
    public static void main(String[] args) {
        String filePath = "src/Data/coding-assigment-orders.json";
        Airplane plane0 = new Airplane(0);
        Airplane plane1 = new Airplane(1);
        Airplane plane2 = new Airplane(2);
        Airplane[] planes = new Airplane[]{plane0, plane1, plane2};

        Map<String, List<String>> destinationMap = JSONToHashMap.parseJsonToHashMap(filePath);
        for(String entry : destinationMap.keySet()){
            System.out.println(entry+":"+destinationMap.get(entry).size());
        }

        List<Components.Flight> flights = new ArrayList();
        int count = 0;
        int flightId = 0;
        int factor = 0;

        for(String entry : destinationMap.keySet()){
            List<Components.Order> orders = new ArrayList<Components.Order>();
            int day = 0;
            
            for(int i = 0;i<destinationMap.get(entry).size();i++){
                String order = destinationMap.get(entry).get(i);
                System.out.println(order);
                if(orders.size() >= 20 || i == destinationMap.get(entry).size() - 1){
                    flights.add(new Components.Flight(flightId + (factor * planes.length) + 1, "YUL", entry, day++, planes[count], new ArrayList(orders)));
                    orders.clear();
                    factor++;
                }
                else{
                    orders.add(new Order(order, flightId + (factor * planes.length) + 1, "YUL", entry, day));
                }
            }
            factor = 0;
            flightId++;
            count++;
        }
        FlightData.getInstance().initialize(flights);
    }
}
