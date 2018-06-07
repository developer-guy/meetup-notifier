package org.meetup.notifier.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author Batuhan Apaydın
 */

@Configuration
@EnableElasticsearchRepositories(basePackages = "org.meetup.notifier.data.elasticsearch.repository")
public class ElasticSearchConfiguration {


}
