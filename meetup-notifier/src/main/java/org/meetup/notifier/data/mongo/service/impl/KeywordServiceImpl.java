package org.meetup.notifier.data.mongo.service.impl;

import org.meetup.notifier.data.mongo.document.Keyword;
import org.meetup.notifier.data.mongo.dto.KeywordDTO;
import org.meetup.notifier.data.mongo.mapper.KeywordMapper;
import org.meetup.notifier.data.mongo.repository.KeywordRepository;
import org.meetup.notifier.data.mongo.service.KeywordService;
import org.meetup.notifier.data.mongo.service.SequenceService;
import org.springframework.core.env.Environment;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Batuhan Apaydın
 */
public class KeywordServiceImpl implements KeywordService {

    private static final String MEETUP_API_TOKEN = "meetup.api.token";
    private String token;
    private final KeywordRepository keywordRepository;
    private final SequenceService sequenceService;
    private final KeywordMapper keywordMapper = KeywordMapper.INSTANCE;
    private final Environment environment;

    public KeywordServiceImpl(KeywordRepository keywordRepository, SequenceService sequenceService, Environment environment) {
        this.keywordRepository = keywordRepository;
        this.sequenceService = sequenceService;
        this.environment = environment;
        this.token = environment.getProperty(MEETUP_API_TOKEN);
    }

    @Override
    public List<KeywordDTO> getUserKeywords() {
        return keywordRepository.findByToken(token)
                .stream()
                .map(keywordMapper::keywordToKeywordDTO)
                .collect(Collectors.toList());
    }

    @Override
    public long save(KeywordDTO keywordDTO) {
        Keyword eventDTOToEvent = keywordMapper.eventDTOToEvent(keywordDTO);
        eventDTOToEvent.setId(sequenceService.next());
        eventDTOToEvent.setToken(token);

        Keyword savedKeyword = keywordRepository.save(eventDTOToEvent);

        return savedKeyword.getId();
    }
}
