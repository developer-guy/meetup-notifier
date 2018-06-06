package org.meetup.notifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.meetup.notifier.data.redis.document.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import redis.embedded.RedisServer;
import redis.embedded.RedisServerBuilder;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Batuhan Apaydın
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class RedisIntegrationTest {

    @Autowired
    private RedisServer redisServer;

    @Autowired
    private RedisTemplate<String, Event> eventRedisTemplate;

    private HashOperations<String, String, Event> hashOperations;

    @TestConfiguration
    public static class RedisTestConfig {

        @Value("${redis.test.port}")
        private int port;

        @Bean
        public RedisServer redisServer() {
            return new RedisServerBuilder()
                    .port(port)
                    .build();
        }

    }

    @Before
    public void setUp() {
        this.hashOperations = eventRedisTemplate.opsForHash();
        redisServer.start();
    }


    @Test
    public void shouldRedisConfigurationSuccesfullyConfigured() {
        //arrange
        Event event = new Event();
        event.setId("12345");

        //act
        hashOperations.put("events:12345", "12345", event);
        Event retrievedEvent = hashOperations.get("events:12345", "12345");

        //assert
        assertThat(retrievedEvent).isNotNull();
    }


    @After
    public void tearDown() {
        if (redisServer.isActive()) {
            redisServer.stop();
        }
    }

}
