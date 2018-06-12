package org.meetup.notifier.configuration;

import org.meetup.notifier.data.mongo.repository.KeywordRepository;
import org.meetup.notifier.data.mongo.service.KeywordService;
import org.meetup.notifier.data.mongo.service.SequenceService;
import org.meetup.notifier.data.mongo.service.impl.SequenceServiceImpl;
import org.meetup.notifier.data.mongo.service.impl.KeywordServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author Batuhan Apaydın
 */

@Configuration
public class ApplicationBeansConfiguration {

    @Bean
    public KeywordService keywordService(KeywordRepository keywordRepository,
                                         SequenceService sequenceService, Environment environment) {
        return new KeywordServiceImpl(keywordRepository, sequenceService, environment);
    }

    @Bean
    public SequenceService sequenceService(MongoTemplate mongoTemplate) {
        return new SequenceServiceImpl(mongoTemplate);
    }
}
