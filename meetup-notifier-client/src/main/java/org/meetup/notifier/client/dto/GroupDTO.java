package org.meetup.notifier.client.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.meetup.notifier.client.dto.deserializer.JoinModeDeserializer;

import java.io.Serializable;

/**
 * @author Batuhan Apaydın
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GroupDTO implements Serializable {
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

    @JsonCreator
    public GroupDTO(@JsonProperty("created") Long created,
                    @JsonProperty("name") String name,
                    @JsonProperty("id") Long id,
                    @JsonProperty("join_mode")
                 @JsonDeserialize(using = JoinModeDeserializer.class)
                         JoinMode joinMode,
                    @JsonProperty("lat") Double latitude,
                    @JsonProperty("lon") Double longitude,
                    @JsonProperty("urlname") String urlName,
                    @JsonProperty("who") String who,
                    @JsonProperty("localized_location") String localizedLocation,
                    @JsonProperty("region") String region,
                    @JsonProperty("timezone") String timeZone) {
        this.created = created;
        this.name = name;
        this.id = id;
        this.joinMode = joinMode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.urlName = urlName;
        this.who = who;
        this.localizedLocation = localizedLocation;
        this.region = region;
        this.timeZone = timeZone;
    }

    private String timeZone;

}
