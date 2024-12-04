package org.example.systemManagment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertTime {

    public static Date convertStringToDate(String dateString) {
        try{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
            return   format.parse(dateString);
        }catch(ParseException e){
            throw new RuntimeException("Incorrect date");
        }
    }
}
