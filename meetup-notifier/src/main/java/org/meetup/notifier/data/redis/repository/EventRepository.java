package org.meetup.notifier.data.redis.repository;

import org.meetup.notifier.data.redis.document.Event;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Batuhan Apaydın
 */
public interface EventRepository extends CrudRepository<Event, String> {
    Event findByName(String name);
}
