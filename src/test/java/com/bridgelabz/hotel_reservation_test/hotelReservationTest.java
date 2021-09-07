package com.bridgelabz.hotel_reservation_test;


import com.bridgelabz.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;

public class hotelReservationTest {
    @Test
    public void ifHotel_Add_GetsSucess() {
        HotelReservation hotelReservation = new HotelReservation();

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

        hotelReservation.printDetails();
        Assert.assertEquals(3, hotelReservation.hotelInfo.size());
    }
}
