package com.fetch.takehome.constants;

public class ReceiptProcessorConstants {


    public static final String RETAIL_PATTERN="^\\S+$";
    public static final String RETAIL_PATTERN_MESSAGE="Retailer name is invalid. It should not contain any white space" +
            "characters";
    public static final String RETAIL_NOT_EMPTY_MESSAGE = "Retailer name is required";
    public static final String PURCHASE_DATE_NOT_EMPTY_MESSAGE = "Purchase date is required";
    public static final String PURCHASE_TIME_NOT_EMPTY_MESSAGE = "Purchase time is required";
    public static final String ITEM_LIST_NOT_EMPTY_MESSAGE = "Item list should contain at least one item";
    public static final String TOTAL_AMOUNT_PATTERN="^\\d+\\.\\d{2}$";
    public static final String TOTAL_AMOUNT_NOT_EMPTY_MESSAGE = "Total amount is required";
    public static final String TOTAL_AMOUNT_PATTERN_MESSAGE = "total amount format is invalid. Correct format example " +
            "- 12.20";
    public static final String SHORT_DESCRIPTION_NOT_EMPTY_MESSAGE = "Short Description is required";
    public static final String ITEM_PRICE_NOT_EMPTY_MESSAGE = "Item price is required";
    public static final String SHORT_DESCRIPTION_PATTERN = "^[\\w\\s\\-]+$";
    public static final String ITEM_PRICE_PATTERN = "^\\d+\\.\\d{2}$";
    public static final String ITEM_PRICE_PATTERN_MESSAGE = "total amount format is invalid. Correct format example" +
            " - 12.20";
    public static final String RECEIPT_NOT_FOUND_MESSAGE = "Receipt not found for id - ";
    public static final String DATE_FORMAT_EXCEPTION_MESSAGE = "Date format not valid for- ";
    public static final String SPACE = " ";
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm";
    public static final String TWO_PM = "14:00";
    public static final String FOUR_PM = "16:00";
    public static final String SHORT_DESCRIPTION_PATTERN_MESSAGE = "Short description format is invalid";
    public static final Integer ZERO = 0;
    public static final Integer TEN = 10;
    public static final Integer SIX = 6;
    public static final Integer FIFTY = 50;
    public static final Integer TWENTY_FIVE = 25;
    public static final Double POINT_TWENTY_FIVE = 0.25;
    public static final String ID = "id";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String DATE_VALIDATION_MESSAGE = "Invalid Date format. Correct format should be yyyy-MM-dd";
    public static final String PURCHASE_TIME_PATTERN="^\\d{2}\\:\\d{2}$";
    public static final String PURCHASE_TIME_PATTERN_MESSAGE = "purchase time is invalid. example - 12:24";
}
