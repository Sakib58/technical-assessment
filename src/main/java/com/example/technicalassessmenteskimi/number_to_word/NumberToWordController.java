package com.example.technicalassessmenteskimi.number_to_word;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/number-to-word")
public class NumberToWordController {

    @GetMapping("/{number}")
    public ResponseEntity<String> getNumberToWord(@PathVariable Double number) {
        return ResponseEntity.ok(NumberUtil.convertNumberToWord(number));
    }
}
