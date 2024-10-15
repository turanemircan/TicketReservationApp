package TicketReservationApp;

        /*
        Project: Bilet Rezervasyon ve Bilet Fiyatı Hesaplama Uygulaması

            1- Uygulama mesafe ve kurallara göre otobüs bileti fiyatı hesaplar sonuç olarak bilet bilgisini verir
            2- Kullanıcıdan     mesafe (KM),
                                yolcu adı, yaşı ,
                                yolculuk tipi (Tek Yön, Gidiş-Dönüş)
                                ve koltuk no bilgilerini alınır.
                     NOT: Koltuk numaraları her otobüs için dinamik olmalıdır.)
                          Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
                          Aksi halde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.

            3-Fiyat hesaplama kuralları:
               -Mesafe başına ücret:
                          Tek yön: 1 Lira / km       Çift Yön(Gidiş-Dönüş): 2 Lira/km
               -Tekli Koltuk ücreti:
                          Koltuk no 3 veya 3 ün katı ise fiyat %20 daha fazladır(Tek yön: 1.2 Lira/km, Çift Yön:2.4 Lira/km).
               -İlk olarak seferin mesafe, yön ve koltuk no bilgisine göre fiyatı hesaplanır,
                sonrasında koşullara göre aşağıdaki indirimler uygulanır ;
                           i)-Çift Yön indirimi:
                                       "Yolculuk Tipi" gidiş dönüş seçilmiş ise son bilet fiyatı üzerinden %20 indirim uygulanır.
                           ii)-Yaş indirimi:
                                        Kişi 12 yaşından küçükse son bilet fiyatı üzerinden %50 indirim uygulanır.
                                        Kişi 65 yaşından büyük ise son bilet fiyatı üzerinden %30 indirim uygulanır.

        */

import java.util.Scanner;

public class TicketReservationApp {
    public static void main(String[] args) {

        start();
    }

    private static void start() {

        // 1- Bilet ve otobüs objelerini oluşturalım.
        Bus bus = new Bus("34 EMR 021", 33);

        Ticket ticket;

        Scanner scanner = new Scanner(System.in);

        int select; // CIKIS icin 0'ı seciniz.

        do {
            // Kullanıcı'dan bilgileri alalım
            System.out.println("Bilet Rezervasyon Sistemine Hosgeldiniz :)");
            System.out.print("Lutfen Ad-Soyad Giriniz = ");
            String name = scanner.nextLine();

            System.out.print("Lutfen Yasinizi Giriniz = ");
            int age = scanner.nextInt(); // \n

            System.out.print("Lutfen Gidilecek Mesafeyi(KM) Giriniz = ");
            double km = scanner.nextDouble();

            System.out.println("1-Tek Yön");
            System.out.println("2-Gidiş-Dönüş");
            System.out.print("Yolculuk Tipini Seciniz = ");
            int type = scanner.nextInt(); // \n

            scanner.nextLine(); // Dummy attık cunku nextInt'ten sonra String degeri okumadan gecer.

            System.out.println(bus.getSeats()); // Koltuk numaralarını listeler.
            System.out.println("Tekli Koltuk Ucreti %20 Daha Fazladir.");
            System.out.print("Lutfen Koltuk No Giriniz = ");
            String seat = scanner.next();

            // Koltuk No rezerve edilmis mi? veya liste de var mi?
            boolean isReserved = !bus.getSeats().contains(seat);
            // True ise rezerve edilmis ya da bu koltuk no otobuste yok.


            // Girilen degerler gecerli mi?
            if (km > 0 && age > 0 && (type == 1 || type == 2) && !isReserved) {
                // bileti hazırla
                ticket = new Ticket(km, type, seat, bus);
                ticket.setPrice(age);

                // rezerve edilen koltuğu listeden kaldıralım
                ticket.getBus().getSeats().remove(seat);

                // bileti yazdıralım
                ticket.printTicket(name);
            } else {
                if (isReserved) {
                    System.out.println("Secilen koltuk mevcut degil veya rezerve edilmistir!");
                } else {
                    System.out.println("Sayin " + name + "hatali veri girdiniz!");
                }
            }
            System.out.print("Yeni islem icin bir sayi giriniz, CIKIS icin 0 giriniz = ");
            select = scanner.nextInt();

            scanner.nextLine();

        } while (select != 0);
        System.out.println("Iyi Gunler Dileriz, Yine Bekleriz...");
    }
}
