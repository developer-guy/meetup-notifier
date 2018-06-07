package org.meetup.notifier.autoconfigure;

import org.junit.Test;
import org.meetup.notifier.auto.configure.configuration.MeetupApiAutoConfiguration;
import org.meetup.notifier.client.service.MeetupService;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Batuhan Apaydın
 */
public class MeetupServiceAutoConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(MeetupApiAutoConfiguration.class));


    @Test
    public void shouldMeetupServiceAutoConfiguredSuccessfully() {
        this.contextRunner
                .run(context -> {
                    assertThat(context).hasBean("meetupService");
                    assertThat(context).hasSingleBean(MeetupService.class);
                });

    }
}
