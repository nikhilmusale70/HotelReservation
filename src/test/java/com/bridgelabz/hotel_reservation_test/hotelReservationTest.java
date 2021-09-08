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
        b.put(CustomerType.REGULAR , new Rate(150, 50) );
        b.put(CustomerType.REWARDED, new Rate(110,50));
        hotelReservation.addHotel("Bridgewood",b,4);

        HashMap<CustomerType, Rate> c = new HashMap<CustomerType, Rate>();
        c.put(CustomerType.REGULAR , new Rate(220, 150) );
        c.put(CustomerType.REWARDED, new Rate(100,40));
        hotelReservation.addHotel("Ridgewood",c,5);

    }

    @Test
    public void nameAndPrice_OfCheapestHotels(){

        LocalDate d1 = LocalDate.of(2020,9,11);
        LocalDate d2 = LocalDate.of(2020,9,12);

        hotelReservation.dates(d1,d2);
        hotelReservation.cheapeastHotel();
        hotelReservation.cheapestBestRatedHotel();
    }

    @Test
    public void bestRatedHotel_WithPrice() {
        LocalDate d1 = LocalDate.of(2020,9,11);
        LocalDate d2 = LocalDate.of(2020,9,12);

        hotelReservation.dates(d1,d2);
        hotelReservation.cheapeastHotel();
        hotelReservation.bestRatedHotel();
    }

    @Test
    public void bestRatedHotel_WithCheapestRate_ForRewardedCustomers() {

        String s1 = "20 09 11";
        String s2 = "20 09 12";

        if(hotelReservation.dateValidation(s1) && hotelReservation.dateValidation(s2)) {

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yy MM dd");
            LocalDate d1 = LocalDate.parse(s1, dateFormat);
            LocalDate d2 = LocalDate.parse(s2, dateFormat);


            hotelReservation.rewardedDates(d1, d2);
            hotelReservation.rewardedCheapeastHotel();
            hotelReservation.rewardedCheapestBestRatedHotel();
        }

        else
            System.out.println("Invalid input");
    }
}
