package org.meetup.notifier.configuration;

import org.meetup.notifier.data.redis.document.Event;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Batuhan Apaydın
 */
@Configuration
@EnableConfigurationProperties(RedisConfigurationProperties.class)
@EnableRedisRepositories(basePackages = "org.meetup.notifier.data.redis.repository")
public class RedisConfiguration {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(RedisConfigurationProperties properties) {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setDatabase(0);
        config.setHostName(properties.getHost());
        config.setPort(properties.getPort());
        return new JedisConnectionFactory(config);
    }

    @Bean
    public RedisTemplate<String, Event> eventRedisTemplate(JedisConnectionFactory jedisConnectionFactory) {
        final RedisTemplate<String, Event> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        Jackson2JsonRedisSerializer<Event> valueSerializer = new Jackson2JsonRedisSerializer<>(Event.class);
        StringRedisSerializer keySerializer = new StringRedisSerializer();
        template.setValueSerializer(valueSerializer);
        template.setHashValueSerializer(valueSerializer);
        template.setKeySerializer(keySerializer);
        template.setHashKeySerializer(keySerializer);
        return template;
    }

}
