package com.henry.limitsservice.controller;


import com.henry.limitsservice.configuration.Configuration;
import com.henry.limitsservice.dto.LimitsDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/limits")
public class LimitsController {

    private final Configuration configuration;

    public LimitsController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping
    public LimitsDto getLimits() {
        return LimitsDto.builder()
                .minimum(configuration.getMinimum())
                .maximum(configuration.getMaximum())
                .build();
    }

}
