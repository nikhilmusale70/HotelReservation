package com.bridgelabz;

import java.util.ArrayList;
import java.util.Map;

public class HotelInfo {

    String hotelName;
    Map<CustomerType, Rate> priceOfHotel;
    int rating;

    public HotelInfo(String hotelName, Map<CustomerType,Rate> priceOfHotel, int rating){
        this.hotelName = hotelName;
        this.priceOfHotel = priceOfHotel;
        this.rating = rating;
    }
}

