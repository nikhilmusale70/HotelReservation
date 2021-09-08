package com.bridgelabz;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    //rewarded customers
    ArrayList<LocalDate> rewardedMultiDates = new ArrayList<LocalDate>(3);
    public void rewardedDates(LocalDate d1, LocalDate d2){
        rewardedMultiDates.add(d1);
        long daysInBetween = ChronoUnit.DAYS.between(d1,d2);

        while (daysInBetween>0){
            rewardedMultiDates.add(rewardedMultiDates.get(rewardedMultiDates.size()-1).plusDays(1));
            daysInBetween--;
        }
    }

    Integer[] rewardedPrice ={0,0,0};
    public void rewardedCheapeastHotel(){

        for (int i=0; i<rewardedMultiDates.size(); i++){
            for (int j=0; j<hotelInfo.size(); j++) {
                if (rewardedMultiDates.get(i).getDayOfWeek().equals(DayOfWeek.SATURDAY) || rewardedMultiDates.get(i).getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                    rewardedPrice[j] += hotelInfo.get(j).priceOfHotel.get(CustomerType.REWARDED).weekEndRate;
                }
                else
                    rewardedPrice[j] += hotelInfo.get(j).priceOfHotel.get(CustomerType.REWARDED).weekDayRate;
            }
        }
    }

    public void rewardedCheapestBestRatedHotel() {
        HotelInfo[] rewardedFlag = new HotelInfo[3];
        ArrayList<Integer> rewardedStoringRating = new ArrayList<>();

        for (int i=0 ; i<hotelInfo.size(); i++){
            for (int j=0; j< rewardedPrice.length ; j++){
                if (i != j) {
                    if (rewardedPrice[i].equals(rewardedPrice[j])) {
                        rewardedFlag[i] = hotelInfo.get(i);
                    }
                }
            }
        }
        for (int i=0; i<rewardedFlag.length; i++){
            rewardedStoringRating.add(hotelInfo.get(i).rating);
        }

        int n = rewardedStoringRating.indexOf(Collections.max(rewardedStoringRating));

        System.out.println("Cheapest hotel with best rate is :- " + hotelInfo.get(n).hotelName + " \nWith rating :- " +hotelInfo.get(n).rating + " \nPrice :- "+ rewardedPrice[n]);

    }

    public boolean dateValidation(String d1){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yy MM dd");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(d1.trim());
        }
        catch (ParseException pe) {
            return false;
        }
        return true;
    }
}
