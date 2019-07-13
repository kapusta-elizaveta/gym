package com.gym.validate;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class Validate {

    private DateTimeFormatter f = DateTimeFormatter.ofPattern( "dd-MM-uuuu" );

    public boolean correctDate (String date)
    {
        try {
            LocalDate start = LocalDate.parse(date,f);
            return true;
        } catch (Exception ex){
            return false;
        }


    }



    public boolean correctPhoneNumber(String phoneNumber){

        return phoneNumber.matches("(\\+)\\d{12}");
    }

    public boolean dates(String startDate , String endDate)
    {

        try {
            LocalDate start = LocalDate.parse(startDate,f);

            LocalDate stop = LocalDate.parse(endDate,f);

            return start.isBefore(stop);

        }catch (Exception ex)
        {
            return false;
        }
    }

    public boolean correctTime(String time){

        return time.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]");
    }

}
