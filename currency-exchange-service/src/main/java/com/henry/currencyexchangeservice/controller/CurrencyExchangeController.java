package com.henry.currencyexchangeservice.controller;

import com.henry.currencyexchangeservice.dto.CurrencyExchange;
import com.henry.currencyexchangeservice.repository.CurrencyExchangeRepo;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/currency-exchange")
public class CurrencyExchangeController {

    private final CurrencyExchangeRepo currencyExchangeRepo;

    private final Environment environment;

    public CurrencyExchangeController(CurrencyExchangeRepo currencyExchangeRepo, Environment environment) {
        this.currencyExchangeRepo = currencyExchangeRepo;
        this.environment = environment;
    }

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange getCurrencyExchange(@PathVariable String from, @PathVariable String to) throws Exception {

        CurrencyExchange currencyExchange = currencyExchangeRepo.findByFromAndTo(from, to);
        if (currencyExchange == null)
            throw new Exception("Not found.");

        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }

}
