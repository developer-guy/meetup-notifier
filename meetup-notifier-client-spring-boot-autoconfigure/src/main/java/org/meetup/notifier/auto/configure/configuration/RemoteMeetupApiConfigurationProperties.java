package org.meetup.notifier.auto.configure.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Batuhan Apaydın
 */
@Data
@ConfigurationProperties(prefix = "meetup.api")
public class RemoteMeetupApiConfigurationProperties {
    private String rootUri;
    private String token;
}
