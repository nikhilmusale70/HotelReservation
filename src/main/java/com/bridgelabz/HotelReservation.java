package com.bridgelabz;

import java.util.ArrayList;
import java.util.Map;

public class HotelReservation {
    public ArrayList<HotelInfo> hotelInfo = new ArrayList<HotelInfo>(3);
    HotelInfo hotelInfoObj;

    public void addHotel(String hotelName, Map<CustomerType,Rate> priceOfHotel, int rating){
        hotelInfoObj = new HotelInfo(hotelName, priceOfHotel, rating);
        hotelInfo.add(hotelInfoObj);

    }
}
