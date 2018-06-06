package org.meetup.notifier.scheduler;

import lombok.extern.java.Log;
import org.meetup.notifier.client.dto.UpcomingEventSchedule;
import org.meetup.notifier.client.service.MeetupService;
import org.meetup.notifier.data.redis.document.Event;
import org.meetup.notifier.data.redis.mapper.EventMapper;
import org.meetup.notifier.data.redis.repository.EventRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Batuhan Apaydın
 */
@Component
@Log
public class UpdateRedisCacheWithUpcomingEventScheduleJob {

    private final MeetupService meetupService;
    private final EventRepository eventRepository;

    public UpdateRedisCacheWithUpcomingEventScheduleJob(MeetupService meetupService, EventRepository eventRepository) {
        this.meetupService = meetupService;
        this.eventRepository = eventRepository;
    }


    @Scheduled(cron = "${cron.expression}")
    public void updateRedisCacheWithUpcomingEventScheduleJob() {
        log.info("Job started... : " + Instant.now().toString());

        UpcomingEventSchedule upComingEvents = meetupService.findUpComingEvents();

        List<Event> eventHashes = upComingEvents.getEvents()
                .stream()
                .map(EventMapper.INSTANCE::eventDTOToEvent)
                .collect(Collectors.toList());

        eventHashes.forEach(eventRepository::save);

        log.info("Job finished... : " + Instant.now().toString());
    }
}
