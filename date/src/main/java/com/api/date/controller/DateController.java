package com.api.date.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class DateController {
    @GetMapping("/date")
    public String getCurrentDate() {
        return LocalDate.now().toString();
    }
}
