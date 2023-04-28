import airport.Flight;
import airport.Passenger;
import exceptions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse("13/02/2022", formatter);

        Flight f1 = new Flight(date, LocalTime.parse("13:00"), "isfahan", "tehran",
                320.5, 55, 780.3, 2);
        Flight f2 = new Flight(date, LocalTime.parse("11:00"), "isfahan", "mashhad",
                900d, 110, 1570.5, 50);
        Flight f3 = new Flight(date, LocalTime.parse("10:00"), "isfahan", "tehran",
                320.5, 55, 780.3, 87);

        String name1 = sc.next();
        String name2 = sc.next();

        String phone1 = null;
        String phone2 = null;

        String email1 = null;
        String email2 = null;
        double balance1 = 0;
        double balance2 = 0;


        Passenger p1 = new Passenger(name1, phone1, email1, balance1);
        Passenger p2 = new Passenger(name2, phone2, email2, balance2);
        Passenger p3 = new Passenger("ali", "9301112233", "abc@gmail.com", 2000.5);
        Passenger p4 = new Passenger("zahra", "989301112233", "abcgl.com", 3000d);


        phone1 = sc.next();
        managePhone(p1, phone1);
        phone2 =  sc.next();
        managePhone(p2, phone2);


        email1 = sc.next();
        manageEmail(p1,email1);
        email2 = sc.next();
        manageEmail(p2,email2);


        balance1 = sc.nextDouble();
        manageBalance(p1,balance1);
        balance2 = sc.nextDouble();
        manageBalance(p2,balance2);

        managePhone(p3, p3.getPhoneNumber());
        managePhone(p4, p4.getPhoneNumber());

        manageEmail(p3,p3.getEmail());
        manageEmail(p4, p4.getEmail());

        manageBalance(p3,p3.getBalance());
        manageBalance(p4,p4.getBalance());

        management(p1, f1);
        management(p1, f2);
        management(p2, f3);
        management(p2, f2);
        management(p3, f1);
        management(p3, f3);
        management(p4, f1);
        management(p4, f2);


    }

    public static void flightDetails(Flight flight) {
        System.out.println("-------------------------------------------------");
        System.out.println(flight.toString());
        System.out.println("Passengers:");
        for (Passenger passenger : flight.getPassengers()) {
            System.out.println(passenger.toString());
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
    }

    public static void management(Passenger passenger, Flight flight) throws FailedReserve {
        System.out.println("flight is reserving for " + passenger.getName());
        try {
            passenger.reserveFlight(flight);

        } catch (SameOrginAndDestination sameOrginAndDestination) {
            System.out.println(sameOrginAndDestination.toString());
        } catch (SameTime sameTime) {
            System.out.println(sameTime.toString());
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("It's full!");
        } catch (NoBalance noBalance) {
            System.out.println(noBalance.toString());
        } finally {
            flightDetails(flight);
        }
    }

    public static void manageBalance(Passenger passenger,double balance) {

        try {
            passenger.checkInitialBalance(balance);
            passenger.setBalance(balance);
        } catch (InputMismatchException inputMismatchException) {
            System.out.println(inputMismatchException.getMessage());
        } catch (WrongBalance wrongBalance) {
            System.out.println(wrongBalance.toString());
            passenger.setBalance(0);
        } finally {
            System.out.println("Balance Done!");
        }
    }

    public static void manageEmail(Passenger passenger,String email) {
        try {
            passenger.checkEmail(email);
            passenger.setEmail(email);
        } catch (InputMismatchException inputMismatchException) {
            System.out.println(inputMismatchException.getMessage());
        } catch (WrongEmail wrongEmail) {
            System.out.println(wrongEmail.toString());
            passenger.setEmail(null);
        } finally {
            System.out.println("Email Done!");
        }
    }

    public static void managePhone(Passenger passenger, String phone) {
        try {
            passenger.checkPhone(phone);
            passenger.setPhoneNumber(phone);
        } catch (InputMismatchException inputMismatchException) {
            System.out.println(inputMismatchException.getMessage());
        } catch (WrongPhoneNumber wrongPhoneNumber) {
            System.out.println(wrongPhoneNumber.toString());
            passenger.setPhoneNumber(null);
        } finally {
            System.out.println("Phone number Done!");
        }
    }

}
