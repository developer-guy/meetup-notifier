package org.meetup.notifier.data.mongo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.meetup.notifier.data.mongo.document.Keyword;
import org.meetup.notifier.data.mongo.dto.KeywordDTO;

/**
 * @author Batuhan Apaydın
 */
@Mapper(componentModel = "spring")
public interface KeywordMapper {

    KeywordMapper INSTANCE = Mappers.getMapper(KeywordMapper.class);

    @Mappings({
            @Mapping(target = "keyword", source = "keyword")
    })
    Keyword eventDTOToEvent(KeywordDTO keywordDTO);

    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "keyword", source = "keyword")
    })
    KeywordDTO keywordToKeywordDTO(Keyword keyword);
}
