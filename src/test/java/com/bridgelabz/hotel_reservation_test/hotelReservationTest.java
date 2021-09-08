package com.bridgelabz.hotel_reservation_test;


import com.bridgelabz.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.script.ScriptContext;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

public class hotelReservationTest {
    HotelReservation hotelReservation = new HotelReservation();
    @Before
    public void ifHotel_Add_GetsSucess() {

        HashMap<CustomerType, Rate> a = new HashMap<CustomerType, Rate>();
        a.put(CustomerType.REGULAR , new Rate(110, 90) );
        a.put(CustomerType.REWARDED, new Rate(80,80));
        hotelReservation.addHotel("Lakewood",a,3);

        HashMap<CustomerType, Rate> b = new HashMap<CustomerType, Rate>();
        b.put(CustomerType.REGULAR , new Rate(160, 60) );
        b.put(CustomerType.REWARDED, new Rate(110,50));
        hotelReservation.addHotel("Bridgewood",b,4);

        HashMap<CustomerType, Rate> c = new HashMap<CustomerType, Rate>();
        c.put(CustomerType.REGULAR , new Rate(220, 150) );
        c.put(CustomerType.REWARDED, new Rate(100,40));
        hotelReservation.addHotel("Ridgewood",c,5);

    }

    @Test
    public void nameAndPrice_OfCheapestHotels() throws IOException {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter date 1 :- ");
//        String s1 = sc.nextLine();
//        System.out.println("Enter date 2 :- ");
//        String s2 = sc.nextLine();
//
//        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yy MM dd");
//        LocalDate d1 = LocalDate.parse(s1,dateFormat);
//        LocalDate d2 = LocalDate.parse(s2, dateFormat);

        LocalDate d1 = LocalDate.of(2020,9,11);
        LocalDate d2 = LocalDate.of(2020,9,12);
        hotelReservation.cheapeastHotel(d1,d2);
    }
}
