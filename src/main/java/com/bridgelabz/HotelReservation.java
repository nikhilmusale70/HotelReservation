package com.bridgelabz;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class HotelReservation {
    public ArrayList<HotelInfo> hotelInfo = new ArrayList<HotelInfo>(3);
    public HotelInfo hotelInfoObj;

    public void addHotel(String hotelName, Map<CustomerType,Rate> priceOfHotel, int rating){
        hotelInfoObj = new HotelInfo(hotelName, priceOfHotel, rating);
        hotelInfo.add(hotelInfoObj);
    }

    public void cheapeastHotel(LocalDate d1, LocalDate d2){
        ArrayList<LocalDate> multiDates = new ArrayList<LocalDate>(3);

        multiDates.add(d1);
        long daysInBetween = ChronoUnit.DAYS.between(d1,d2);

        while (daysInBetween>0){
            multiDates.add(multiDates.get(multiDates.size()-1).plusDays(1));
            daysInBetween--;
        }

        Integer[] price ={0,0,0};
        for (int i=0; i<multiDates.size(); i++){
            for (int j=0; j<hotelInfo.size(); j++) {

                if (multiDates.get(i).getDayOfWeek().equals(DayOfWeek.SATURDAY) || multiDates.get(i).getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                    price[j] += hotelInfo.get(j).priceOfHotel.get(CustomerType.REGULAR).weekEndRate;
                }
                else
                    price[j] += hotelInfo.get(j).priceOfHotel.get(CustomerType.REGULAR).weekDayRate;
            }
        }

        int n = Arrays.asList(price).indexOf(Collections.min(Arrays.asList(price)));
        System.out.println("Cheapest hotel is :- " + hotelInfo.get(n).hotelName + " Price :- "+ price[n]);
    }
}
