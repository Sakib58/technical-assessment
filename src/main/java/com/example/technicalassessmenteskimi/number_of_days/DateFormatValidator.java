package com.example.technicalassessmenteskimi.number_of_days;

public class DateFormatValidator {
    public static boolean isValidDate(String date) {

        // YYYY-MM-DD
        if (date.matches("^(\\d{4}-(0[1-9]|1[0-2]|[1-9])-(0[1-9]|1[0-9]|2[0-9]|3[0-1]|[1-9]))$")) {
            int year = Integer.parseInt(date.split("-")[0]);
            int month = Integer.parseInt(date.split("-")[1]);
            int day = Integer.parseInt(date.split("-")[2]);
            return isValidDay(year, month, day);
        }

        // DD/MM/YYYY
        if (date.matches("^(0[1-9]|1[0-9]|2[0-9]|3[0-1]|[1-9])/(0[1-9]|1[0-2]|[1-9])/\\d{4}$")) {
            int day = Integer.parseInt(date.split("/")[0]);
            int month = Integer.parseInt(date.split("/")[1]);
            int year = Integer.parseInt(date.split("/")[2]);
            return isValidDay(year, month, day);
        }

        return false;
    }

    private static boolean isValidDay(int year, int month, int day) {

        if (year < 1 || month < 1 || month > 12 || day < 1) {
            return false;
        }

        int[] daysInMonth = {
                31, isLeapYear(year) ? 29 : 28, 31, 30,
                31, 30, 31, 31,
                30, 31, 30, 31
        };

        return day <= daysInMonth[month - 1];
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
