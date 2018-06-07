package org.meetup.notifier.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * @author Batuhan Apaydın
 */
@Configuration
@EnableRedisRepositories(basePackages = "org.meetup.notifier.data.redis.repository")
public class RedisConfiguration {

}
