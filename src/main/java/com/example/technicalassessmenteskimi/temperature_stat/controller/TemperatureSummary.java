package com.example.technicalassessmenteskimi.temperature_stat.controller;

import com.example.technicalassessmenteskimi.temperature_stat.dto.TemperatureRequestDto;
import com.example.technicalassessmenteskimi.temperature_stat.dto.TemperatureResponseDto;
import com.example.technicalassessmenteskimi.temperature_stat.service.DhakaTemperatureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/temperature-summary")
public class TemperatureSummary {
    private final DhakaTemperatureService dhakaTemperatureService;

    public TemperatureSummary(DhakaTemperatureService dhakaTemperatureService) {
        this.dhakaTemperatureService = dhakaTemperatureService;
    }

    @PostMapping
    public ResponseEntity<TemperatureResponseDto> postTemperature(@RequestBody TemperatureRequestDto requestDto) {
        return ResponseEntity.ok(dhakaTemperatureService.getDhakaTemperatureSummary(requestDto));
    }
}
