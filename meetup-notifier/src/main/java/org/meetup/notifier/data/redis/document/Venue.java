package org.meetup.notifier.data.redis.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
