package com.example.technicalassessmenteskimi.number_of_days;

public class CustomDate {
    private final int year;
    private final int month;
    private final int day;

    public CustomDate(int year, int month, int day) {
        validate(year, month, day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    private void validate(int year, int month, int day) {
        if (year < 1) {
            throw new IllegalArgumentException("Invalid year");
        }

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month");
        }

        int maxDays = daysInMonth(year, month);
        if (day < 1 || day > maxDays) {
            throw new IllegalArgumentException("Invalid day");
        }
    }

    private int daysInMonth(int year, int month) {
        return switch (month) {
            case 2 -> isLeapYear(year) ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getYYYYMMDD() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }
}
