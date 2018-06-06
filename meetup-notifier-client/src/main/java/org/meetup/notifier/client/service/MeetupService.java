package org.meetup.notifier.client.service;

import org.meetup.notifier.client.dto.UpcomingEventSchedule;

/**
 * @author Batuhan Apaydın
 */
public interface MeetupService {
    UpcomingEventSchedule findUpComingEvents();
}
