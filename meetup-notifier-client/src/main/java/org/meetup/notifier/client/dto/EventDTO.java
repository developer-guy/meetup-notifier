package org.meetup.notifier.client.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.meetup.notifier.client.dto.deserializer.StatusDeserializer;
import org.meetup.notifier.client.dto.deserializer.VisibilityDeserializer;

import java.io.Serializable;

/**
 * @author Batuhan Apaydın
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDTO implements Serializable {
    private Long created;
    private Long duration;
    private String id;
    private String name;
    private int reservationLimit;
    private Status status;
    private Long time;
    private String localDate;
    private String localTime;
    private Long updated;
    private Long utcOffset;
    private int waitlistCount;
    private int yesReservationCount;
    private VenueDTO venue;
    private GroupDTO group;
    private String link;
    private String description;
    private String howToFindUs;
    private Visibility visibility;

    @JsonCreator
    public EventDTO(@JsonProperty("created") Long created,
                    @JsonProperty("duration") Long duration,
                    @JsonProperty("id") String id,
                    @JsonProperty("name") String name,
                    @JsonProperty("rsvp_limit") int reservationLimit,
                    @JsonProperty("status")
                 @JsonDeserialize(using = StatusDeserializer.class) Status status,
                    @JsonProperty("time") Long time,
                    @JsonProperty("local_date") String localDate,
                    @JsonProperty("local_time") String localTime,
                    @JsonProperty("updated") Long updated,
                    @JsonProperty("utc_offset") Long utcOffset,
                    @JsonProperty("waitlist_count") int waitlistCount,
                    @JsonProperty("yes_rsvp_count") int yesReservationCount,
                    @JsonProperty("venue") VenueDTO venue,
                    @JsonProperty("group") GroupDTO group,
                    @JsonProperty("link") String link,
                    @JsonProperty("description") String description,
                    @JsonProperty("how_to_find_us") String howToFindUs,
                    @JsonProperty("visibility")
                 @JsonDeserialize(using = VisibilityDeserializer.class) Visibility visibility) {
        this.created = created;
        this.duration = duration;
        this.id = id;
        this.name = name;
        this.reservationLimit = reservationLimit;
        this.status = status;
        this.time = time;
        this.localDate = localDate;
        this.localTime = localTime;
        this.updated = updated;
        this.utcOffset = utcOffset;
        this.waitlistCount = waitlistCount;
        this.yesReservationCount = yesReservationCount;
        this.venue = venue;
        this.group = group;
        this.link = link;
        this.description = description;
        this.howToFindUs = howToFindUs;
        this.visibility = visibility;
    }

}
