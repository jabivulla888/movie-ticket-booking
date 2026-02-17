package com.xyz.booking.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ShowClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public boolean isSeatAvailable(Long showId, int requestedSeats) {

        String url = "http://localhost:8081/api/shows/" + showId;
        ShowResponse response =
                restTemplate.getForObject(url, ShowResponse.class);

        return response != null &&
               response.getAvailableSeats() >= requestedSeats;
    }
}
