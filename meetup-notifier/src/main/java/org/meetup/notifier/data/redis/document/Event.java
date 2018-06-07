package org.meetup.notifier.data.redis.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.meetup.notifier.client.dto.Status;
import org.meetup.notifier.client.dto.Visibility;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Batuhan Apaydın
 */
@RedisHash("events")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event implements Serializable {

    @Id
    private String id;
    private Long created;
    private Long duration;
    @Indexed
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
    private Venue venue;
    private Group group;
    private String link;
    private String description;
    private String howToFindUs;
    private Visibility visibility;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(getId(), event.getId()) &&
                Objects.equals(getName(), event.getName()) &&
                Objects.equals(getDescription(), event.getDescription());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getDescription());
    }
}
