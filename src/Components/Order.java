package Components;

public class Order {
    String orderName;
    int flightNumber;
    String departure;
    String destination;
    int day;

    public Order(String orderName, int flightNumber, String departure, String destination, int day){
        this.orderName = orderName;
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.day = day;
    }
        public String getOrderName() {
            return orderName;
        }
    
        public int getFlightNumber() {
            return flightNumber;
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
}
