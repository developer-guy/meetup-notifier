package org.meetup.notifier.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Batuhan Apaydın
 */
@Data
@ConfigurationProperties(prefix = "redis")
public class RedisConfigurationProperties {
    private int port;
    private String host;
}
