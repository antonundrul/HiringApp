package com.company.hiringapp.controller;

import org.springframework.validation.BindingResult;

import java.time.format.DateTimeFormatter;

public final class ControllerHelper {

    private ControllerHelper() {

    }

    static final String DATE_FORMAT = "yyyy-MM-dd HH.mm";
    static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

    static boolean checkBindingResult(BindingResult bindingResult) {
        return bindingResult.hasErrors();
    }

    static String redirectTo(String redirectTo) {
        return "redirect:/" + redirectTo;
    }

    static String goBackTo(String goBackTo) {
        return goBackTo;
    }
}
