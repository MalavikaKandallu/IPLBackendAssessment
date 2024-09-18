package org.example;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfiguration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("insert-match-data", r -> r.path("/api/matches/upload")
                        .uri("http://localhost:8081"))  // Forward to cricket microservice
                .route("get-matches-by-player", r -> r.path("/api/matches/player/**")
                        .uri("http://localhost:8081"))  // Forward to cricket microservice
                .route("get-cumulative-score", r -> r.path("/api/matches/cumulativeScore/**")
                        .uri("http://localhost:8081"))  // Forward to cricket microservice
                .route("get-scores-by-date", r -> r.path("/api/matches/date/**")
                        .uri("http://localhost:8081"))  // Forward to cricket microservice
                .route("get-top-batsmen", r -> r.path("/api/matches/batsmen/top")
                        .uri("http://localhost:8081"))  // Forward to cricket microservice
                .build();
    }
}