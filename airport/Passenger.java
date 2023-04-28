package airport;

import exceptions.*;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passenger {
    private String name;
    private String phoneNumber;
    private String email;
    private double balance;
    public ArrayList<Flight> flights = new ArrayList<>();

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public double getBalance() {
        return this.balance;
    }

    public ArrayList<Flight> getFlights() {
        return this.flights;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public Passenger(String name, String phoneNumber, String email, double balance) throws WrongPhoneNumber, WrongEmail, WrongBalance {
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.phoneNumber = phoneNumber;
    }

    public void checkEmail(String email) throws WrongEmail {
        Pattern pattern = Pattern.compile("^\\w+@(yahoo|gmail)\\.com$");
        Matcher matcher = pattern.matcher(email);
        if (!matcher.find()) {
            throw new WrongEmail();
        } else {
            this.email = email;
        }
    }

    public void checkPhone(String phone) throws WrongPhoneNumber {
        Pattern pattern = Pattern.compile("^98\\d{10}$");
        Matcher matcher = pattern.matcher(phone);
        if (!matcher.find()) {
            throw new WrongPhoneNumber();
        } else {
            this.phoneNumber = phone;
        }
    }

    public void checkInitialBalance(double balance) throws WrongBalance {
        if (balance < 0) {
            throw new WrongBalance();
        } else {
            this.balance = balance;
        }
    }

    public void reserveFlight(Flight flight) throws FailedReserve {
        getFlights().add(flight);
        flight.getPassengers().add(this);
        ///wrong origin and destination

        if (flights.size() > 1) {
            int index = flights.indexOf(flight);
            if (!flight.getOrigin().toUpperCase().equals(flights.get(index - 1).getDestination().toUpperCase())) {
                flights.remove(flight);
                flight.getPassengers().remove(this);
                throw new SameOrginAndDestination();
            }
        }

        ///same time error
        if (flights != null) {
            for (Flight fly : flights) {
                if (!fly.equals(flight)) {
                    if (flight.getDate() == fly.getDate()) {
                        if (Math.abs(fly.getTime().getHour() - flight.getTime().getHour()) < 2) {
                            flights.remove(flight);
                            flight.getPassengers().remove(this);
                            throw new SameTime();
                        }
                    }
                }
            }
        }

        ///full error
        if (flight.getCapacity() < flight.getCounter()) {
            flights.remove(flight);
            flight.getPassengers().remove(this);
            throw new IndexOutOfBoundsException();
        }
        else {
            flight.setCounter(flight.getCounter()+1);
        }

        ///less money

        if (flight.getCost() > balance) {
            flight.setCounter(flight.getCounter()-1);
            flights.remove(flight);
            flight.getPassengers().remove(this);
            throw new NoBalance();
        }
        else {
            this.balance-=flight.getCost();
        }
    }

    public String toString() {
        return "Name: " + getName() + "\nPhone number: " + getPhoneNumber() + "\nEmail: " + getEmail() + "\nBalance: " + getBalance();
    }
}
