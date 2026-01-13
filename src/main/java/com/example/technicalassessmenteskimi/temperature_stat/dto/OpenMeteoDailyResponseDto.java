package com.example.technicalassessmenteskimi.temperature_stat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpenMeteoDailyResponseDto {
    List<Double> temperature_2m_max;
    List<Double> temperature_2m_min;
}
