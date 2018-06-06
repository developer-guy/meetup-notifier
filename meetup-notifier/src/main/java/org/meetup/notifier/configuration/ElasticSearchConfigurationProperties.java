package org.meetup.notifier.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Batuhan Apaydın
 */
@Data
@ConfigurationProperties(prefix = "elasticsearch")
public class ElasticSearchConfigurationProperties {
    private String clusterName;
    private String host;
    private int port;
}
