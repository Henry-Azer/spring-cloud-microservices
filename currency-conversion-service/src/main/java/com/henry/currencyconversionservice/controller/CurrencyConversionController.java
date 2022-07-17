package com.henry.currencyconversionservice.controller;

import com.henry.currencyconversionservice.dto.CurrencyConversion;
import com.henry.currencyconversionservice.service.CurrencyConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/currency-conversion")
public class CurrencyConversionController {

    private final CurrencyConversionService currencyConversionService;

    public CurrencyConversionController(CurrencyConversionService currencyConversionService) {
        this.currencyConversionService = currencyConversionService;
    }

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    private CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable BigDecimal quantity, @PathVariable String to) {
        return currencyConversionService.convert(from, to, quantity);
    }
}
