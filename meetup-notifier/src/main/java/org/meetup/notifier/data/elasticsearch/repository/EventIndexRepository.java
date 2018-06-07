package org.meetup.notifier.data.elasticsearch.repository;

import org.meetup.notifier.data.elasticsearch.document.EventIndex;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Batuhan Apaydın
 */
public interface EventIndexRepository extends ElasticsearchRepository<EventIndex, String> {

}