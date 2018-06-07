package org.meetup.notifier.data.redis.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.meetup.notifier.client.dto.EventDTO;
import org.meetup.notifier.data.redis.document.Event;

/**
 * @author Batuhan Apaydın
 */
@Mapper(componentModel = "spring")
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    Event eventDTOToEvent(EventDTO eventDTO);
}
