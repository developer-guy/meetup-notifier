package org.meetup.notifier.auto.configure.configuration;

import org.meetup.notifier.client.service.MeetupService;
import org.meetup.notifier.client.service.RemoteMeetupApiService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

/**
 * @author Batuhan Apaydın
 */
@Configuration
@EnableConfigurationProperties(RemoteMeetupApiConfigurationProperties.class)
@ConditionalOnClass(RestTemplate.class)
public class MeetupApiAutoConfiguration {

    @ConditionalOnMissingBean(RemoteMeetupApiService.class)
    @Bean
    public MeetupService meetupService(RestTemplate restTemplate) {
        return new RemoteMeetupApiService(restTemplate);
    }

    @Bean
    public RestTemplate restTemplate(RemoteMeetupApiConfigurationProperties properties) {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        return restTemplateBuilder
                .rootUri(properties.getRootUri())
                .interceptors(new RestTemplateApiKeyInterceptopr(properties.getToken()))
                .build();
    }

    private static class RestTemplateApiKeyInterceptopr implements ClientHttpRequestInterceptor {
        private final String token;

        private RestTemplateApiKeyInterceptopr(String token) {
            this.token = token;
        }

        public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
            if (StringUtils.hasText(token)) {
                request.getHeaders().add("Authorization", "Bearer " + token);
            }
            return execution.execute(request, body);
        }
    }
}
