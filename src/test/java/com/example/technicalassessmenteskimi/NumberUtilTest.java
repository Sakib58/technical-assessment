package com.example.technicalassessmenteskimi;

import com.example.technicalassessmenteskimi.number_to_word.NumberUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberUtilTest {
    @Test
    void shouldConvertZero() {
        assertEquals("Zero Point Zero", NumberUtil.convertNumberToWord(0));
    }

    @Test
    void shouldConvertSingleDigit() {
        assertEquals("Five Point Zero", NumberUtil.convertNumberToWord(5));
    }

    @Test
    void shouldConvertTwoDigitNumber() {
        assertEquals("Twenty Three Point Zero", NumberUtil.convertNumberToWord(23));
    }

    @Test
    void shouldConvertThreeDigitNumber() {
        assertEquals("One Hundred Twenty Five Point Zero", NumberUtil.convertNumberToWord(125));
    }

    @Test
    void shouldConvertOneThousand() {
        assertEquals("One Thousand Point Zero", NumberUtil.convertNumberToWord(1000));
    }

    @Test
    void shouldConvertOneDecimalDigit() {
        assertEquals(
                "Twelve Point Five",
                NumberUtil.convertNumberToWord(12.5)
        );
    }

    @Test
    void shouldConvertTwoDecimalDigits() {
        assertEquals(
                "Nine Point Two Five",
                NumberUtil.convertNumberToWord(9.25)
        );
    }

    @Test
    void shouldConvertZeroDecimal() {
        assertEquals(
                "Ten Point Zero",
                NumberUtil.convertNumberToWord(10.0)
        );
    }

    @Test
    void shouldConvertDecimalWithTrailingZero() {
        assertEquals(
                "Seven Point Five",
                NumberUtil.convertNumberToWord(7.50)
        );
    }

    @Test
    void shouldRejectNegativeNumber() {
        assertThrows(
                IllegalArgumentException.class,
                () -> NumberUtil.convertNumberToWord(-1)
        );
    }

    @Test
    void shouldRejectMoreThanThousand() {
        assertThrows(
                IllegalArgumentException.class,
                () -> NumberUtil.convertNumberToWord(1000.01)
        );
    }

    @Test
    void shouldRejectMoreThanTwoDecimalDigits() {
        assertThrows(
                IllegalArgumentException.class,
                () -> NumberUtil.convertNumberToWord(12.345)
        );
    }
}
