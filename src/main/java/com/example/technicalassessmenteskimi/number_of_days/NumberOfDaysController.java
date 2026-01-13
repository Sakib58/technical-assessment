package com.example.technicalassessmenteskimi.number_of_days;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/number-of-days")
public class NumberOfDaysController {

    @PostMapping("/without-end-date")
    public ResponseEntity<Integer> getNumberOfDaysWithoutEndDate(
            @RequestBody DateRangeRequestDto dateRangeRequestDto
    ) {
        return ResponseEntity.ok(
                DateUtil.getDateDifference(
                        DateUtil.parseDate(dateRangeRequestDto.getEndDate()),
                        DateUtil.parseDate(dateRangeRequestDto.getStartDate()
                        )
                )
        );
    }

    @PostMapping("/with-end-date")
    public ResponseEntity<Integer> getNumberOfDaysWithEndDate(
            @RequestBody DateRangeRequestDto dateRangeRequestDto
    ) {
        return ResponseEntity.ok(
                DateUtil.getDateDifferenceWithEndDate(
                        DateUtil.parseDate(dateRangeRequestDto.getEndDate()),
                        DateUtil.parseDate(dateRangeRequestDto.getStartDate()
                        )
                )
        );
    }
}
