package org.meetup.notifier.data.redis.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.meetup.notifier.client.dto.JoinMode;

import java.util.Objects;

/**
 * @author Batuhan Apaydın
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    private Long created;
    private String name;
    private Long id;
    private JoinMode joinMode;
    private Double latitude;
    private Double longitude;
    private String urlName;
    private String who;
    private String localizedLocation;
    private String region;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(getCreated(), group.getCreated()) &&
                Objects.equals(getName(), group.getName()) &&
                Objects.equals(getId(), group.getId()) &&
                getJoinMode() == group.getJoinMode() &&
                Objects.equals(getLatitude(), group.getLatitude()) &&
                Objects.equals(getLongitude(), group.getLongitude()) &&
                Objects.equals(getUrlName(), group.getUrlName()) &&
                Objects.equals(getWho(), group.getWho()) &&
                Objects.equals(getLocalizedLocation(), group.getLocalizedLocation()) &&
                Objects.equals(getRegion(), group.getRegion());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCreated(), getName(), getId(), getJoinMode(), getLatitude(), getLongitude(), getUrlName(), getWho(), getLocalizedLocation(), getRegion());
    }
}
