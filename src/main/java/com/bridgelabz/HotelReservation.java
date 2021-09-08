package com.bridgelabz;

import java.lang.reflect.Array;
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

    ArrayList<LocalDate> multiDates = new ArrayList<LocalDate>(3);
    public void dates(LocalDate d1, LocalDate d2){
        multiDates.add(d1);
        long daysInBetween = ChronoUnit.DAYS.between(d1,d2);

        while (daysInBetween>0){
            multiDates.add(multiDates.get(multiDates.size()-1).plusDays(1));
            daysInBetween--;
        }
    }

    Integer[] price ={0,0,0};
    public void cheapeastHotel(){

        for (int i=0; i<multiDates.size(); i++){
            for (int j=0; j<hotelInfo.size(); j++) {
                if (multiDates.get(i).getDayOfWeek().equals(DayOfWeek.SATURDAY) || multiDates.get(i).getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                    price[j] += hotelInfo.get(j).priceOfHotel.get(CustomerType.REGULAR).weekEndRate;
                }
                else
                    price[j] += hotelInfo.get(j).priceOfHotel.get(CustomerType.REGULAR).weekDayRate;
            }
        }
    }

    public void cheapestBestRatedHotel() {
        ArrayList<HotelInfo> flag = new ArrayList<HotelInfo>(3);
        ArrayList<Integer> storingRating = new ArrayList<>();

        for (int i=0 ; i<hotelInfo.size(); i++){
            for (int j=0; j< price.length ; j++){
                if (i != j) {
                    if (price[i].equals(price[j])) {
                        flag.add(hotelInfo.get(i));
                    }
                }
            }
        }
        for (int i=0; i<flag.size(); i++){
            storingRating.add(hotelInfo.get(i).rating);
        }
    }

    public void bestRatedHotel(){
    ArrayList<Integer> bestRated = new ArrayList<Integer>();

        for (int i=0; i<hotelInfo.size() ;i++){
            bestRated.add(hotelInfo.get(i).rating);
        }
        int n = bestRated.indexOf(Collections.max(bestRated));
        System.out.println("Best rated Hotel Name :- " + hotelInfo.get(n).hotelName + " Price :- " + price[n]);
        
    }
}
