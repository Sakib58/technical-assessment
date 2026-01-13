package com.example.technicalassessmenteskimi.number_of_days;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DateRangeRequestDto {
    private String startDate;
    private String endDate;
}
