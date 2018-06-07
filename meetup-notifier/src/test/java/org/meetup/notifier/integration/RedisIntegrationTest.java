package org.meetup.notifier.integration;

import org.jetbrains.annotations.NotNull;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.meetup.notifier.MeetupNotifierApplication;
import org.meetup.notifier.data.redis.document.Event;
import org.meetup.notifier.data.redis.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.GenericContainer;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Batuhan Apaydın
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(initializers = RedisIntegrationTest.Initializer.class)
public class RedisIntegrationTest {

    @ClassRule
    public static GenericContainer redis =
            new GenericContainer("redis:3.2")
                    .withExposedPorts(6379);

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(@NotNull ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues values = TestPropertyValues.of(
                    "spring.redis.host=" + redis.getContainerIpAddress(),
                    "spring.redis.port=" + redis.getMappedPort(6379)
            );
            values.applyTo(configurableApplicationContext);
        }







    }

    @Autowired
    private EventRepository eventRepository;

    @Test
    public void shouldRedisConfigurationSuccesfullyConfigured() {
        //arrange
        Event event = new Event();
        event.setId("12345");
        event.setName("Sample Event");

        //act
        eventRepository.save(event);
        Event retrievedEvent = eventRepository.findByName("Sample Event");

        //assert
        assertThat(retrievedEvent).isNotNull();
        assertThat(retrievedEvent.getId()).isEqualTo(event.getId());
        assertThat(retrievedEvent.getName()).isEqualTo(event.getName());

    }
}
