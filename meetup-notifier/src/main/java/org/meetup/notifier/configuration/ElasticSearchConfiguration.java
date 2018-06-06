package org.meetup.notifier.configuration;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Batuhan Apaydın
 */

@Configuration
@EnableConfigurationProperties(ElasticSearchConfigurationProperties.class)
@EnableElasticsearchRepositories(basePackages = "org.meetup.notifier.data.elasticsearch.repository")
public class ElasticSearchConfiguration {
    @Bean
    public Client elasticSearchClient(ElasticSearchConfigurationProperties properties) throws UnknownHostException {
        Settings settings = Settings
                .builder()
                .put("cluster.name", properties.getClusterName())
                .build();

        TransportClient client = new PreBuiltTransportClient(settings);
        TransportAddress address =
                new InetSocketTransportAddress(InetAddress.getByName(properties.getHost()), properties.getPort());
        client.addTransportAddress(address);

        return client;
    }

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate(Client elasticSearchClient) {
        return new ElasticsearchTemplate(elasticSearchClient);
    }

}
