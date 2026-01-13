package com.example.technicalassessmenteskimi.number_of_days;

import java.util.Arrays;
import java.util.List;

public class DateUtil {

    static final int[] totalDaysUptoMonth = {
            0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365
    };

    private static int totalNumberOfDaysFromZero(CustomDate date) {
        return 365*(date.getYear()-1) + totalDaysUptoMonth[date.getMonth()-1] + date.getDay() + countTotalNumberOfLeapYearsUpto(date);
    }

    private static int countTotalNumberOfLeapYearsUpto(CustomDate date) {
        int year = date.getYear();
        if (date.getMonth() <= 2)
            year--;
        return (year/4) - (year/100) + (year/400);
    }

    public static CustomDate parseDate(String date) {
        int year, month, day;
        List<Integer> dateSplit;
        if (date.contains("-")) {
            dateSplit = Arrays.stream(date.split("-"))
                    .map(Integer::parseInt)
                    .toList();
            year = dateSplit.get(0);
            month = dateSplit.get(1);
            day = dateSplit.get(2);
        }
        else if (date.contains("/")) {
            dateSplit = Arrays.stream(date.split("/"))
                    .map(Integer::parseInt)
                    .toList();
            day = dateSplit.get(0);
            month = dateSplit.get(1);
            year = dateSplit.get(2);
        }
        else throw new IllegalArgumentException("Invalid date: " + date);
        return new CustomDate(year, month, day);
    }

    public static int getDateDifference(CustomDate date1, CustomDate date2) {
        return Math.abs(totalNumberOfDaysFromZero(date2) - totalNumberOfDaysFromZero(date1));
    }

    public static int getDateDifferenceWithEndDate(CustomDate date1, CustomDate date2) {
        return getDateDifference(date1, date2) + 1;
    }
}
