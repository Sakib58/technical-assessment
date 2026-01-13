package com.example.technicalassessmenteskimi;

import com.example.technicalassessmenteskimi.number_of_days.CustomDate;
import com.example.technicalassessmenteskimi.number_of_days.DateUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateUtilTest {
    @Test
    void sameDate_differenceShouldBeZero() {
        CustomDate d1 = new CustomDate(2024, 1, 1);
        CustomDate d2 = new CustomDate(2024, 1, 1);

        assertEquals(0, DateUtil.getDateDifference(d1, d2));
        assertEquals(1, DateUtil.getDateDifferenceWithEndDate(d1, d2));
    }

    @Test
    void consecutiveDates_differenceShouldBeOne() {
        CustomDate d1 = new CustomDate(2024, 1, 1);
        CustomDate d2 = new CustomDate(2024, 1, 2);

        assertEquals(1, DateUtil.getDateDifference(d1, d2));
        assertEquals(2, DateUtil.getDateDifferenceWithEndDate(d1, d2));
    }

    @Test
    void reverseOrderDates_shouldReturnSameDifference() {
        CustomDate d1 = new CustomDate(2024, 5, 10);
        CustomDate d2 = new CustomDate(2024, 5, 1);

        assertEquals(9, DateUtil.getDateDifference(d1, d2));
        assertEquals(10, DateUtil.getDateDifferenceWithEndDate(d1, d2));
    }

    @Test
    void yearBoundary_shouldCalculateCorrectly() {
        CustomDate d1 = new CustomDate(2023, 12, 31);
        CustomDate d2 = new CustomDate(2024, 1, 1);

        assertEquals(1, DateUtil.getDateDifference(d1, d2));
        assertEquals(2, DateUtil.getDateDifferenceWithEndDate(d1, d2));
    }

    @Test
    void leapYearFebruary_shouldHandleLeapDay() {
        CustomDate d1 = new CustomDate(2024, 2, 28);
        CustomDate d2 = new CustomDate(2024, 3, 1);

        assertEquals(2, DateUtil.getDateDifference(d1, d2));
        assertEquals(3, DateUtil.getDateDifferenceWithEndDate(d1, d2));
    }

    @Test
    void nonLeapYearFebruary_shouldSkipLeapDay() {
        CustomDate d1 = new CustomDate(2023, 2, 28);
        CustomDate d2 = new CustomDate(2023, 3, 1);

        assertEquals(1, DateUtil.getDateDifference(d1, d2));
        assertEquals(2, DateUtil.getDateDifferenceWithEndDate(d1, d2));
    }
}
