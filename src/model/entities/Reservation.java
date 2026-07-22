package model.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reservation {

    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    private static DateTimeFormatter dt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }


    public LocalDate getCheckOut() {
        return checkOut;
    }

    public long duration() {
        Duration duration = Duration.between(this.checkIn.atStartOfDay(), this.checkOut.atStartOfDay());
        return duration.toDays();
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room " +
                this.roomNumber +
                ", check-in: " +
                dt1.format(this.checkIn) +
                ", check-out: " +
                dt1.format(this.checkOut) +
                ", " +
                duration() +
                " nights";
    }
}
