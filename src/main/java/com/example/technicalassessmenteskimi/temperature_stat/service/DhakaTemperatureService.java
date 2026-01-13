package com.example.technicalassessmenteskimi.temperature_stat.service;

import com.example.technicalassessmenteskimi.number_of_days.CustomDate;
import com.example.technicalassessmenteskimi.number_of_days.DateFormatValidator;
import com.example.technicalassessmenteskimi.number_of_days.DateUtil;
import com.example.technicalassessmenteskimi.number_to_word.NumberUtil;
import com.example.technicalassessmenteskimi.temperature_stat.dto.OpenMeteoResponseDto;
import com.example.technicalassessmenteskimi.temperature_stat.dto.TemperatureRequestDto;
import com.example.technicalassessmenteskimi.temperature_stat.dto.TemperatureResponseDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DhakaTemperatureService {

    public TemperatureResponseDto getDhakaTemperatureSummary(
            TemperatureRequestDto temperatureRequestDto
    ) {
        assert DateFormatValidator.isValidDate(temperatureRequestDto.getStartDate());
        assert DateFormatValidator.isValidDate(temperatureRequestDto.getEndDate());
        CustomDate startDate = DateUtil.parseDate(temperatureRequestDto.getStartDate());
        CustomDate endDate = DateUtil.parseDate(temperatureRequestDto.getEndDate());
        String url =
                "https://api.open-meteo.com/v1/forecast"
                        + "?latitude=23.8103"
                        + "&longitude=90.4125"
                        + "&start_date=" + startDate.getYYYYMMDD()
                        + "&end_date=" + endDate.getYYYYMMDD()
                        + "&daily=temperature_2m_max,temperature_2m_min"
                        + "&timezone=Asia/Dhaka";

        RestTemplate restTemplate = new RestTemplate();
        OpenMeteoResponseDto response =
                restTemplate.getForObject(
                        String.format(url, startDate, endDate),
                        OpenMeteoResponseDto.class);
        int numberOfDays = DateUtil.getDateDifferenceWithEndDate(startDate, endDate);
        BigDecimal totalAvgSum = BigDecimal.ZERO;
        BigDecimal minTemp = null;
        BigDecimal maxTemp = null;

        for (int i = 0; i < numberOfDays; i++) {
            assert response != null;
            BigDecimal max = BigDecimal.valueOf(response.getDaily().getTemperature_2m_max().get(i));
            BigDecimal min = BigDecimal.valueOf(response.getDaily().getTemperature_2m_min().get(i));

            BigDecimal dailyAvg = max.add(min)
                    .divide(BigDecimal.valueOf(2), 2, RoundingMode.HALF_UP);

            totalAvgSum = totalAvgSum.add(dailyAvg);

            minTemp = (minTemp == null || min.compareTo(minTemp) < 0) ? min : minTemp;
            maxTemp = (maxTemp == null || max.compareTo(maxTemp) > 0) ? max : maxTemp;
        }

        assert response != null;
        BigDecimal averageTemp = totalAvgSum
                .divide(BigDecimal.valueOf(numberOfDays), 2, RoundingMode.HALF_UP);
        if (minTemp == null)
            minTemp = BigDecimal.ZERO;
        if (maxTemp == null)
            maxTemp = BigDecimal.ZERO;
        minTemp = minTemp.setScale(2, RoundingMode.HALF_UP);
        maxTemp = maxTemp.setScale(2, RoundingMode.HALF_UP);
        averageTemp = averageTemp.setScale(2, RoundingMode.HALF_UP);

        return TemperatureResponseDto.builder()
                .minimumTemperature(minTemp)
                .maximumTemperature(maxTemp)
                .averageTemperature(averageTemp)
                .minimumTemperatureText(NumberUtil.convertNumberToWord(minTemp.doubleValue()))
                .maximumTemperatureText(NumberUtil.convertNumberToWord(maxTemp.doubleValue()))
                .averageTemperatureText(NumberUtil.convertNumberToWord(averageTemp.doubleValue()))
                .build();
    }
}
