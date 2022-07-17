package com.henry.currencyconversionservice.service;

import com.henry.currencyconversionservice.dto.CurrencyConversion;
import com.henry.currencyconversionservice.proxy.CurrencyExchangeProxy;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    private final Environment environment;

    private final CurrencyExchangeProxy currencyExchangeProxy;

    public CurrencyConversionServiceImpl(Environment environment, CurrencyExchangeProxy currencyExchangeProxy) {
        this.environment = environment;
        this.currencyExchangeProxy = currencyExchangeProxy;
    }

    @Override
    public CurrencyConversion convert(String from, String to, BigDecimal quantity) {

//        HashMap<String, String> uriVariables = new HashMap<>();
//        uriVariables.put("from", from);
//        uriVariables.put("to", to);

//        CurrencyConversion currencyConversion = new RestTemplate().getForEntity("http://localhost:8000/api/currency-exchange/from/USD/to/EGP", CurrencyConversion.class, uriVariables).getBody();
//        assert currencyConversion != null;

        CurrencyConversion currencyConversion = currencyExchangeProxy.getExchangeValue(from, to);

        return CurrencyConversion.builder()
                .id(currencyConversion.getId())
                .from(from).to(to).quantity(quantity)
                .conversionMultiple(currencyConversion.getConversionMultiple())
                .totalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()))
                .environment(environment.getProperty("local.server.port")).build();
    }
}
