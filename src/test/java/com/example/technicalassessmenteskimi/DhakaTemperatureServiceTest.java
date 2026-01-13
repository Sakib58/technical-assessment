package com.example.technicalassessmenteskimi;

import com.example.technicalassessmenteskimi.temperature_stat.dto.TemperatureRequestDto;
import com.example.technicalassessmenteskimi.temperature_stat.dto.TemperatureResponseDto;
import com.example.technicalassessmenteskimi.temperature_stat.service.DhakaTemperatureService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DhakaTemperatureServiceTest {


    @Test
    public void shouldGetTemperatureSummary() {
        DhakaTemperatureService dhakaTemperatureService = new DhakaTemperatureService();
        TemperatureResponseDto response = dhakaTemperatureService.getDhakaTemperatureSummary(TemperatureRequestDto.builder()
                        .startDate("2026-01-01")
                        .endDate("2026-01-11")
                .build());

        assertEquals(BigDecimal.valueOf(10.10).setScale(2, RoundingMode.HALF_UP), response.getMinimumTemperature());
        assertEquals(BigDecimal.valueOf(23.80).setScale(2, RoundingMode.HALF_UP), response.getMaximumTemperature());
        assertEquals(BigDecimal.valueOf(16.12).setScale(2, RoundingMode.HALF_UP), response.getAverageTemperature());

        assertEquals("Ten Point One", response.getMinimumTemperatureText());
        assertEquals("Twenty Three Point Eight", response.getMaximumTemperatureText());
        assertEquals("Sixteen Point One Two", response.getAverageTemperatureText());
    }
}
