package com.henry.currencyconversionservice.service;

import com.henry.currencyconversionservice.dto.CurrencyConversion;

import java.math.BigDecimal;

public interface CurrencyConversionService {

    CurrencyConversion convert(String from, String to, BigDecimal quantity);
}
