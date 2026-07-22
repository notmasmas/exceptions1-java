package application;

import model.entities.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-in date: ");
        LocalDate checkIn = LocalDate.parse(sc.next(), dt1);
        System.out.print("Check-out date: ");
        LocalDate checkOut = LocalDate.parse(sc.next(), dt1);

        if (checkIn.isAfter(checkOut)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Enter check-in date: ");
            checkIn = LocalDate.parse(sc.next(), dt1);
            System.out.print("Check-out date: ");
            checkOut = LocalDate.parse(sc.next(), dt1);

            LocalDate now = LocalDate.now();

            if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
                System.out.println("Error in reservation: Reservation dates for update must be future dates");
            }
            else if (checkIn.isAfter(checkOut)) {
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            }
            else {
                reservation.updateDates(checkIn, checkOut);
                System.out.println("Reservation updated!");
                System.out.println("Reservation: " + reservation);
            }
        }
    }
}
