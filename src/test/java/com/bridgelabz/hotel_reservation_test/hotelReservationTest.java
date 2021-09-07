package com.bridgelabz.hotel_reservation_test;


import com.bridgelabz.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
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
    public void nameAndPrice_OfChipestHotels() {
        LocalDate d1 = LocalDate.of(2020,9,10);
        LocalDate d2 = LocalDate.of(2020,9,11);
        hotelReservation.cheapeastHotel(d1,d2);
    }
}
