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
public class CityDTO implements Serializable {
    private Long id;
    private String city;
    private Double longitute;
    private Double latitude;
    private String state;
    private String country;
    private String zip;
    private Integer memberCount;

    @JsonCreator
    public CityDTO(@JsonProperty("id") Long id,
                   @JsonProperty("city") String city,
                   @JsonProperty("lon") Double longitute,
                   @JsonProperty("lat") Double latitude,
                   @JsonProperty("state") String state,
                   @JsonProperty("country") String country,
                   @JsonProperty("zip") String zip,
                   @JsonProperty("member_count") Integer memberCount) {
        this.id = id;
        this.city = city;
        this.longitute = longitute;
        this.latitude = latitude;
        this.state = state;
        this.country = country;
        this.zip = zip;
        this.memberCount = memberCount;
    }


}
