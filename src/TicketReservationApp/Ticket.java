package TicketReservationApp;

public class Ticket {

    // 4- mesafe(KM), yolculuk tipi, koltuk no, fiyat, otobüs

    private double distance;

    private int typeNo; // 1- Tek yon 2- Cift yon

    private String seatNo;

    private double price;

    // composition:bir sınıfın başka bir sınıfın örneğine sahip olmasıdır,
    // has a ilişkisi vardır
    // Yani her oluşturduğumuz classın adı aynı zamanda data tipi olur
    private Bus bus; // Bu bilet hangi otobüse ait

    // Parametreli const
    public Ticket(double distance, int typeNo, String seatNo, Bus bus) {
        this.distance = distance;
        this.typeNo = typeNo;
        this.seatNo = seatNo;
        this.bus = bus;
    }

    // getter & setter

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getTypeNo() {
        return typeNo;
    }

    public void setTypeNo(int typeNo) {
        this.typeNo = typeNo;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public double getPrice() {
        return price;
    }

    // 5- Bilet fiyatını kurallara göre hesaplama ve set etme
    public void setPrice(int age) {
        // Buradaki hesaplamalar sonucunda ancak deger set edilebilir.
        double total = 0;
        int seat = Integer.valueOf(this.seatNo); // String tipinde bir degerin icinde sayısal değerler var ise sadece sayisal degerleri alir.

        switch (this.typeNo) { // 1: tek yon veya 2: Cift yon
            case 1: // tek yon
                if (seat % 3 == 0) {
                    total = distance * 1.2;
                } else {
                    total = distance * 1;
                }
                System.out.println("Toplam tutar : " + total); // Normal de fiyat uygulama içinde yazılacak ara degeri gormek icin yazdık
                break;
            case 2:
                if (seat % 3 == 0) {
                    total = distance * 2.4;
                } else {
                    total = distance * 2;
                }
                System.out.println("Toplam tutar : " + total);
                total = total * 0.8; // %20 indirim
                System.out.println("Çift yön indirimli tutar = " + total);
                break;
        }

        // yas indirimi
        if (age < 12) {
            total = total * 0.5;
            System.out.println("12 yaş indirimli tutar = " + total);
        } else if (age > 65) {
            total = total * 0.7;
            System.out.println("65 yaş indirimli tutar = " + total);
        }

        this.price = total;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    // 6- Bilet dokumunu yazdiralim
    public void printTicket(String name) {
        System.out.println("*".repeat(42)); // repeat yazdiginiz deger kadar string degeri yazdirir.
        System.out.println("--- Bilet Detayi ---");
        System.out.println("Sayin " + name);
        System.out.println("Otobüs Plakasi = " + this.bus.getNumberPlate());
        System.out.println("Mesafe(KM)     = " + this.distance);
        System.out.println("Yolculuk Tipi  = " + (this.typeNo == 1 ? "Tek Yon" : "Cift Yon"));
        System.out.println("Koltuk No      = " + this.seatNo);
        System.out.println("Toplam Tutar   = " + this.price);
        System.out.println("Keyifli Yolculuklar Dileriz...");
        System.out.println("*".repeat(42));
    }
}
