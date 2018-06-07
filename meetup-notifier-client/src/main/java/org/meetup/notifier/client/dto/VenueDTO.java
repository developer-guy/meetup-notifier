package org.meetup.notifier.client.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Batuhan Apaydın
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class VenueDTO implements Serializable {
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

    @JsonCreator
    public VenueDTO(
            @JsonProperty("id") Long id,
            @JsonProperty("name") String name,
            @JsonProperty("lat") Double latitude,
            @JsonProperty("lon") Double longitude,
            @JsonProperty("repinned") boolean rePinned,
            @JsonProperty("address_1") String address1,
            @JsonProperty("address_2") String address2,
            @JsonProperty("city") String city,
            @JsonProperty("country") String country,
            @JsonProperty("localized_country_name") String localizedCountryName) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rePinned = rePinned;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.country = country;
        this.localizedCountryName = localizedCountryName;
    }

}
