package org.meetup.notifier.data.mongo.service.impl;

import org.meetup.notifier.data.mongo.document.CustomSequences;
import org.meetup.notifier.data.mongo.service.SequenceService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * @author Batuhan Apaydın
 */
public class SequenceServiceImpl implements SequenceService {
    public static final String SEQ_NAME = "customSequences";

    private final MongoTemplate mongoTemplate;

    public SequenceServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public int next() {
        CustomSequences counter = mongoTemplate.findAndModify(
                query(where("_id").is(SEQ_NAME)),
                new Update().inc("seq", 1),
                options().returnNew(true).upsert(true),
                CustomSequences.class);
        return counter.getSeq();
    }
}