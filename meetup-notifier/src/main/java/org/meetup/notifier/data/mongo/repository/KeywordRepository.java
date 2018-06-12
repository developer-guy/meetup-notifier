package org.meetup.notifier.data.mongo.repository;

import org.meetup.notifier.data.mongo.document.Keyword;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Batuhan Apaydın
 */

public interface KeywordRepository extends MongoRepository<Keyword, Long> {
}
