package com.fetch.takehome.utils;

import com.fetch.takehome.constants.ReceiptProcessorConstants;
import com.fetch.takehome.exception.DateFormatException;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class ReceiptUtils {

    public static String generateId(){
        return UUID.randomUUID().toString();
    }

    public static Date convertStringToDate(String date,String time) {
        String pattern = ReceiptProcessorConstants.DATE_TIME_PATTERN;
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat(pattern);
        dateTimeFormat.setLenient(false);
        Date dateTime = null;
        try {
            dateTime = dateTimeFormat.parse(date+ReceiptProcessorConstants.SPACE+time);
        } catch (ParseException e) {
            throw new DateFormatException(ReceiptProcessorConstants.DATE_FORMAT_EXCEPTION_MESSAGE +
                    date+ReceiptProcessorConstants.SPACE+time);
        }
        return dateTime;
    }
    public static boolean isValidDate(String date){
        String pattern = ReceiptProcessorConstants.DATE_PATTERN;
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);
            return true; // Parsing successful, date is in valid format
        } catch (ParseException e) {
            return false; // Parsing failed, date is not in valid format
        }
    }
}
