package org.meetup.notifier.data.redis.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author Batuhan Apaydın
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venue {
    private Long id;
    private String name;
    private Double latitude;
    private Double longitude;
    private boolean rePinned;
    private String address1;
    private String address2;
    private String city;
    private String country;
    private String localizedCountryName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venue venue = (Venue) o;
        return isRePinned() == venue.isRePinned() &&
                Objects.equals(getId(), venue.getId()) &&
                Objects.equals(getName(), venue.getName()) &&
                Objects.equals(getLatitude(), venue.getLatitude()) &&
                Objects.equals(getLongitude(), venue.getLongitude()) &&
                Objects.equals(getAddress1(), venue.getAddress1()) &&
                Objects.equals(getAddress2(), venue.getAddress2()) &&
                Objects.equals(getCity(), venue.getCity()) &&
                Objects.equals(getCountry(), venue.getCountry()) &&
                Objects.equals(getLocalizedCountryName(), venue.getLocalizedCountryName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getName(), getLatitude(), getLongitude(), isRePinned(), getAddress1(), getAddress2(), getCity(), getCountry(), getLocalizedCountryName());
    }
}
