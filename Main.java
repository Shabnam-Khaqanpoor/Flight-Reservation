import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

         // *if you are using LocalDateTime, change the formatter for it.
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

        String phone1 = sc.next();
        String phone2 = sc.next();

        String email1 = sc.next();
        String email2 = sc.next();

        double balance1 = sc.nextDouble();
        double balance2 = sc.nextDouble();

        Passenger p1 = new Passenger(name1, phone1, email1, balance1);
        Passenger p2 = new Passenger(name2, phone2, email2, balance2);
        Passenger p3 = new Passenger("ali", "9301112233", "abc@gmail.com", 2000.5);
        Passenger p4 = new Passenger("zahra", "989301112233", "abcgl.com", 3000d);


        p1.reserveFlight(f1);
        p1.reserveFlight(f2);

        p2.reserveFlight(f3);
        p2.reserveFlight(f2);

        p3.reserveFlight(f1);
        p3.reserveFlight(f3);

        p4.reserveFlight(f1);
        p4.reserveFlight(f2);

    }
}

class Flight {
    private LocalDate date;
    private LocalTime time;
    // or:
    // private LocalDateTime dateTime;
    private ArrayList<Passenger> passengers;
    private String origin;
    private String destination;
    private double distance;
    private int duration;
    private int speed;
    private double cost;
    private int capacity;

    public Flight(LocalDate date, LocalTime time, String origin, String destination,
                  double distance, int duration, double cost, int capacity) {
        //Exceptions?!!
        //........
    }
    
    // with LocalDateTime uncomment this constructor:
//     public Flight(LocalDateTime dateTime, String origin, String destination,
//                   double distance, int duration, double cost, int capacity) {
//         //Exceptions?!!
//         //........
//     }
}

class Passenger {
    private String name;
    private String phoneNumber;
    private String email;
    private double balance;
    private ArrayList<Flight> flights;

    public Passenger(String name, String phoneNumber, String email, double balance) {
        //........
    }

    private void checkEmail(String email) {
        //Exceptions!!!!
        //........
    }

    private void checkPhone(String phone) {
        //Exceptions!!!!
        //........
    }

    private void checkInitialBalance(String balance) {
        //Exceptions!!!!
        //........
    }

    public void reserveFlight(Flight flight) {
        //Exceptions!!!!
        // تداخل ساعت - عدم موجودی کافی - تکمیل ظرفیت پرواز - یکسان بودن مبدا پرواز قبلی با مقصد پرواز جدید
        //........
    }
}
