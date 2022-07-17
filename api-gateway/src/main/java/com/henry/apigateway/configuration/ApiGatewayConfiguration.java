package com.henry.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p.path("/currency-exchange/**")
                        .filters(f -> f.rewritePath("/currency-exchange/(?<path>.*)", "/${path}"))
                        .uri("lb://currency-exchange-service"))
                .route(p -> p.path("/currency-conversion/**")
                        .filters(f -> f.rewritePath("/currency-conversion/(?<path>.*)", "/${path}")).
                        uri("lb://currency-conversion-service"))
                .build();
    }
}
