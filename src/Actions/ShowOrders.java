package Actions;
import java.util.List;
import java.util.PriorityQueue;

import Components.Order;
import Data.FlightData;

public class ShowOrders {
    public static void printOrderInfo(){
        List<Components.Flight> data = FlightData.getInstance().getFlightData();
        PriorityQueue<Order> pq = new PriorityQueue<Order>((a,b) -> Integer.compare(Integer.parseInt(a.getOrderName().substring(a.getOrderName().length() - 3)), Integer.parseInt(b.getOrderName().substring(b.getOrderName().length() - 3))));
        for(int i = 0;i<data.size();i++){
            for(Order order : data.get(i).getOrders()){
                pq.offer(order);
            }
        }

        while(!pq.isEmpty()){
            System.out.println("-----------------------------------------------");
            Components.Order order = pq.poll();
            System.out.print("Order: "+order.getOrderName());
            System.out.print(", flightNumber:"+order.getFlightNumber());
            System.out.print(", departure:"+order.getDeparture());
            System.out.print(", destination:" + order.getDestination());
            System.out.print(", day:" + order.getDay());
            System.out.println();
        }

    }
}
