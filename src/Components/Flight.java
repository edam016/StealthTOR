package Components;
import java.util.List;

public class Flight {

    int flightId;
    String departure;
    String destination;
    int day;
    Airplane airplane;
    List<Order> orders;

    public Flight(int flightId, String departure, String destination, int day, Airplane airplane, List<Order> orders){
        this.flightId = flightId;
        this.departure = departure;
        this.destination = destination;
        this.day = day;
        this.airplane = airplane;
        this.orders = orders;
    }

    public int getFlightId() {
        return flightId;
    }
    
    public String getDeparture() {
        return departure;
    }
    
    public String getDestination() {
        return destination;
    }

    public int getDay(){
        return day;
    }

    public List<Order> getOrders(){
        return orders;
    }
}
