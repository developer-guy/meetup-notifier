package org.meetup.notifier.data.redis.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.meetup.notifier.client.dto.JoinMode;

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
}
