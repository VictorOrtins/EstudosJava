package entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import exceptions.ReservationException;

public class Reservation {
    public static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation() {
        this.roomNumber = null;
        checkIn = null;
        checkOut = null;
    }
    
    public Reservation(Integer roomNumber) {
        this.roomNumber = roomNumber;
        this.checkIn = null;
        this.checkOut = null;
    }

    public int duration(){
        return (int)Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay()).toDays();
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut) throws ReservationException{
        if(Duration.between(checkIn.atStartOfDay(), checkOut.atStartOfDay()).toDays() < 0){
            throw new ReservationException("Error in Reservation: Check-Out date must be after Check-In date");
        }
        else if(this.checkIn != null && Duration.between(this.checkIn.atStartOfDay(), checkIn.atStartOfDay()).toDays() < 0){
            throw new ReservationException("Error in Reservation: Reservation dates for update must be future dates");
        }

        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder("Reservation: Room ");

        ret.append(roomNumber + ", check-in: ");
        ret.append(checkIn.format(format) + ", check-out: ");
        ret.append(checkOut.format(format) + ", ");
        ret.append(duration() + " nights\n");

        return ret.toString();
    }

    public Integer getRoomNumber() {
        return this.roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return this.checkIn;
    }

    public LocalDate getCheckOut() {
        return this.checkOut;
    }

}
