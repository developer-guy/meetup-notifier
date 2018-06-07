package org.meetup.notifier.data.elasticsearch.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.meetup.notifier.client.dto.EventDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Batuhan Apaydın
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "event_index", type = "events")
public class EventIndex implements Serializable {
    @Id
    private String id;

    private String name;

    private String description;

    public EventIndex(EventDTO event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventIndex that = (EventIndex) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getDescription());
    }
}
