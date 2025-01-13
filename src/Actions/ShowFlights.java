package Actions;
import java.util.List;
import java.util.PriorityQueue;

import Data.FlightData;

public class ShowFlights {

    public static void printFlightInfo(){
        List<Components.Flight> data = FlightData.getInstance().getFlightData();
        PriorityQueue<Components.Flight> pq = new PriorityQueue<Components.Flight>((a,b) ->Integer.compare(a.getDay(), b.getDay()));
        for(int i = 0;i < data.size();i++){
            pq.offer(data.get(i));
        }
        while(!pq.isEmpty()){
            System.out.println("-----------------------------------------------");
            Components.Flight flight = pq.poll();
            System.out.print("Flight: "+flight.getFlightId());
            System.out.print(", departure:"+flight.getDeparture());
            System.out.print(", arrival:"+flight.getDestination());
            System.out.print(", day:" + flight.getDay());
            System.out.println();
        }
    }
}
