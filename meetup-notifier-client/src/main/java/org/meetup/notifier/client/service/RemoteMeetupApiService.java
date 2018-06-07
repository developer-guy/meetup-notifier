package org.meetup.notifier.client.service;

import org.meetup.notifier.client.dto.UpcomingEventSchedule;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;

/**
 * @author Batuhan Apaydın
 */
public class RemoteMeetupApiService implements MeetupService {
    private final RestTemplate restTemplate;

    private static final String FIND_UP_COMING_EVENTS = "/find/upcoming_events";

    public RemoteMeetupApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public UpcomingEventSchedule findUpComingEvents() {
        return invoke(FIND_UP_COMING_EVENTS, HttpMethod.GET, UpcomingEventSchedule.class);
    }

    private <T> T invoke(String url,
                         HttpMethod httpMethod,
                         Class<T> classz) {
        HttpHeaders defaultHttpHeadersWithNoHeader = new HttpHeaders();
        HttpEntity<T> defaultHttpEntityWithDefaultHttpHeaders = new HttpEntity<>(defaultHttpHeadersWithNoHeader);
        return invoke(url, httpMethod, defaultHttpEntityWithDefaultHttpHeaders, classz, Collections.emptyMap());
    }

    private <T> T invoke(String url,
                         HttpMethod httpMethod,
                         HttpEntity<T> requestEntity,
                         Class<T> classz,
                         Map<String, ?> parameters) {
        T body;
        try {
            ResponseEntity<T> response = restTemplate.exchange(url,
                    httpMethod,
                    requestEntity,
                    classz,
                    parameters);
            if (response.getStatusCode().is2xxSuccessful()) {
                body = response.getBody();
            } else {
                throw new HttpClientErrorException(response.getStatusCode());
            }
        } catch (RestClientException e) {
            throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
                    e.getCause().toString());
        }
        return body;
    }
}
