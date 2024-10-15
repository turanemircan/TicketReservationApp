package TicketReservationApp;

import java.util.ArrayList;
import java.util.List;

public class Bus {

    // Class'lar kaliplarimizdir. Bu class'lardan obje olusturacaz
    // 2- plaka, koltuk sayısı, koltuk numaralari : özellik, alan , field, instance veriable

    private String numberPlate; // 34 TPE 789

    private int numberOfSeat;

    private List<String> seats = new ArrayList<>(); // "1", "2", ..... , "33"

    // 3- parametreli constructor: otobus objesini olusturdugumda ozellikleri belli olsun.

    public Bus(String numberPlate, int numberOfSeat) { // parametre de kullandıgımız değişken isimler ile fieald isimleri aynı olmak zorunda değil ancak best practice olan aynı olmasıdır.
        this.numberPlate = numberPlate; // 34 TPE 789
        this.numberOfSeat = numberOfSeat; // 33
        for (int i = 1; i <= this.numberOfSeat; i++) {
            this.seats.add(String.valueOf(i)); // i'nin degerini String'e donusur.
            // this.seats.add(i + ""); // i'nin degerini String'e donusur.
        }
    }

    // getter : field degerlerin okunmasını saglar.

    public String getNumberPlate() {
        return numberPlate;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public List<String> getSeats() {
        return seats;
    }

    // setter : field degerlerini degistirilmesini saglar

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }
}
