package org.meetup.notifier.data.mongo.service;

import org.meetup.notifier.data.mongo.dto.KeywordDTO;

import java.util.List;

/**
 * @author Batuhan Apaydın
 */
public interface KeywordService {
    List<KeywordDTO> getUserKeywords();

    long save(KeywordDTO keyword);

}
