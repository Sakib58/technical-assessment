package com.example.technicalassessmenteskimi.number_to_word;

public class NumberUtil {

    private static final String[] ONES = {
            "Zero", "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] TENS = {
            "", "", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public static String convertNumberToWord(double input) {

        if (!isValid(input)) {
            throw new IllegalArgumentException("Invalid number. Allowed: 0–1000 with max 2 decimal digits");
        }

        String inputStr = String.valueOf(input);
        String[] parts = inputStr.split("\\.");
        int integerPart = Integer.parseInt(parts[0]);
        StringBuilder result = new StringBuilder();

        // Integer part
        if (integerPart == 1000) {
            result.append("One Thousand");
        } else {
            result.append(convertUptoHundred(integerPart).trim());
        }

        // Decimal part
        if (parts.length == 2) {
            result.append(" Point ");
            for (char c : parts[1].toCharArray()) {
                result.append(ONES[c - '0']).append(" ");
            }
        }

        return result.toString().trim();
    }

    private static boolean isValid(double input) {
        return input >= 0 && input <= 1000 && hasTwoDigitAfterDecimal(input);
    }

    private static boolean hasTwoDigitAfterDecimal(double input) {
        String inputStr = String.valueOf(input);
        String decimalStr = inputStr.split("\\.")[1];
        return decimalStr.length() <= 2;
    }

    private static String convertUptoHundred(int number) {
        if (number == 0) return "Zero";

        StringBuilder words = new StringBuilder();

        if (number >= 100) {
            words.append(ONES[number / 100]).append(" Hundred ");
            number %= 100;
        }

        if (number >= 20) {
            words.append(TENS[number / 10]).append(" ");
            number %= 10;
        }

        if (number > 0) {
            words.append(ONES[number]).append(" ");
        }

        return words.toString();
    }
}
