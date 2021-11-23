package com.company.hiringapp.controller;

import com.company.hiringapp.exception.ResourceNotFoundException;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class CustomErrorController implements ErrorController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public String handle() {
        return "util/error/errorPage";
    }

    @GetMapping(value = "/error")
    public String errorPage(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "util/error/errorPage";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "util/error/serverError";
            }
        }
        return "util/error/errorPage";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
