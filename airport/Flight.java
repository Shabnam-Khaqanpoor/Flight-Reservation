package airport;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Flight {
    private LocalDate date;
    private LocalTime time;
    private ArrayList<Passenger> passengers=new ArrayList<>();
    private String origin;
    private String destination;
    private double distance;
    private int duration;
    private int speed;
    private double cost;
    private int capacity;
    private int counter = 0;

    public LocalTime getTime() {
        return time;
    }

    public void setCounter(int counter) {
        this.counter=counter;
    }

    public int getCounter() {
        return this.counter;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public String getOrigin() {
        return origin;
    }

    public double getDistance() {
        return distance;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getCost() {
        return cost;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDuration() {
        return duration;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public Flight(LocalDate date, LocalTime time, String origin, String destination,
                  double distance, int duration, double cost, int capacity) throws Exception {
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.origin = origin;
        this.capacity = capacity;
        this.cost = cost;
        this.distance = distance;
        this.destination = destination;
        try {
            this.speed = (int) (this.distance / ((this.duration/60)));
        }catch (ArithmeticException arithmeticException){
            this.speed=(int)this.distance ;
        }
    }

    public String toString() {
        return "Date: " + getDate() + "\nTime: " + getTime() + "\nOrigin: " + getOrigin()
                + "\nDestination: " + getDestination() + "\nDistance: " + getDistance() + "\nDuration: " + getDuration() +
                "\nSpeed: " + getSpeed() + "\nCapacity: " + getCapacity() + "\nCost: " + getCost();
    }
}
