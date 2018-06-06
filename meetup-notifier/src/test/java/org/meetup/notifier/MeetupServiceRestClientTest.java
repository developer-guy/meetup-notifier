package org.meetup.notifier;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.meetup.notifier.client.dto.UpcomingEventSchedule;
import org.meetup.notifier.client.service.MeetupService;
import org.meetup.notifier.client.service.RemoteMeetupApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;

/**
 * @author Batuhan Apaydın
 */

@RunWith(SpringRunner.class)
@RestClientTest(RemoteMeetupApiService.class)
public class MeetupServiceRestClientTest {

    @Autowired
    private MeetupService remoteMeetupApiService;

    @Autowired
    private MockRestServiceServer serviceServer;

    @Autowired
    private ObjectMapper objectMapper;

    @TestConfiguration
    static class Config {

        @Bean
        public MeetupService remoteMeetupService(RestTemplateBuilder builder) {
            return new RemoteMeetupApiService(builder.build());
        }

        @Bean
        public ObjectMapper objectMapper() {
            return new ObjectMapper();
        }
    }


    @Test
    public void findUpComingEventsWhenResultIsSuccessShouldReturnSchedule() throws JsonProcessingException {
        //arrange
        UpcomingEventSchedule mockBody = new UpcomingEventSchedule();
        String mockBodyAsJson = this.objectMapper.writeValueAsString(mockBody);
        //act
        this.serviceServer
                .expect(MockRestRequestMatchers.requestTo("/find/upcoming_events"))
                .andRespond(MockRestResponseCreators.withSuccess(mockBodyAsJson, MediaType.APPLICATION_JSON));
        UpcomingEventSchedule upcomingEventSchedule = this.remoteMeetupApiService.findUpComingEvents();
        //assert
        Assertions.assertThat(upcomingEventSchedule).isNotNull();
    }
}
