package com.example.technicalassessmenteskimi.temperature_stat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TemperatureResponseDto {
    private BigDecimal minimumTemperature;
    private BigDecimal maximumTemperature;
    private BigDecimal averageTemperature;
    private String minimumTemperatureText;
    private String maximumTemperatureText;
    private String averageTemperatureText;
}
