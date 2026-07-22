package application;

import model.entities.Reservation;
import model.exceptions.DomainException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            DateTimeFormatter dt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date: ");
            LocalDate checkIn = LocalDate.parse(sc.next(), dt1);
            System.out.print("Check-out date: ");
            LocalDate checkOut = LocalDate.parse(sc.next(), dt1);

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Enter check-in date: ");
            checkIn = LocalDate.parse(sc.next(), dt1);
            System.out.print("Check-out date: ");
            checkOut = LocalDate.parse(sc.next(), dt1);

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);
        }
        catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error!");
        }
    }
}
