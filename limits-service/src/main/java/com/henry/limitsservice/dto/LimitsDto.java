package com.henry.limitsservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LimitsDto {
    private int minimum;
    private int maximum;
}
