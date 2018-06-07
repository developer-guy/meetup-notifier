package org.meetup.notifier.client.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Batuhan Apaydın
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpcomingEventSchedule implements Serializable {
    private CityDTO city;
    private List<EventDTO> events;

    @JsonCreator
    public UpcomingEventSchedule(
            @JsonProperty("city") CityDTO city,
            @JsonProperty("events") List<EventDTO> events) {
        this.city = city;
        this.events = events;
    }
}
