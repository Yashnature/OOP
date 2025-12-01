import java.util.Scanner;

public class MovieTicket {
    String movieName;
    int seatNumber;
    double price;
    boolean booked;

    MovieTicket(String movieName, double price) {
        this.movieName = movieName;
        this.price = price;
        this.booked = false;
    }

    void bookTicket(int seatNumber) {
        if (!booked) {
            this.seatNumber = seatNumber;
            this.booked = true;
            System.out.println("Ticket booked successfully!");
        } else {
            System.out.println("Sorry, this ticket is already booked.");
        }
    }

    void displayTicketDetails() {
        if (booked) {
            System.out.println("\n--- Ticket Details ---");
            System.out.println("Movie Name : " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price      : " + price);
        } else {
            System.out.println("No ticket booked yet.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Movie Name: ");
        String movie = sc.nextLine();

        System.out.print("Enter Ticket Price: ");
        double price = sc.nextDouble();

        MovieTicket ticket = new MovieTicket(movie, price);

        System.out.print("Enter Seat Number to Book: ");
        int seat = sc.nextInt();

        ticket.bookTicket(seat);
        ticket.displayTicketDetails();

        sc.close();
    }
}