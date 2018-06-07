package org.meetup.notifier.data.redis.mapper;

import javax.annotation.Generated;
import org.meetup.notifier.client.dto.EventDTO;
import org.meetup.notifier.client.dto.GroupDTO;
import org.meetup.notifier.client.dto.VenueDTO;
import org.meetup.notifier.data.redis.document.Event;
import org.meetup.notifier.data.redis.document.Group;
import org.meetup.notifier.data.redis.document.Venue;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-06-06T15:53:19+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_152 (Oracle Corporation)"
)
@Component
public class EventMapperImpl implements EventMapper {

    @Override
    public Event eventDTOToEvent(EventDTO eventDTO) {
        if ( eventDTO == null ) {
            return null;
        }

        Event event = new Event();

        event.setId( eventDTO.getId() );
        event.setCreated( eventDTO.getCreated() );
        event.setDuration( eventDTO.getDuration() );
        event.setName( eventDTO.getName() );
        event.setReservationLimit( eventDTO.getReservationLimit() );
        event.setStatus( eventDTO.getStatus() );
        event.setTime( eventDTO.getTime() );
        event.setLocalDate( eventDTO.getLocalDate() );
        event.setLocalTime( eventDTO.getLocalTime() );
        event.setUpdated( eventDTO.getUpdated() );
        event.setUtcOffset( eventDTO.getUtcOffset() );
        event.setWaitlistCount( eventDTO.getWaitlistCount() );
        event.setYesReservationCount( eventDTO.getYesReservationCount() );
        event.setVenue( venueDTOToVenue( eventDTO.getVenue() ) );
        event.setGroup( groupDTOToGroup( eventDTO.getGroup() ) );
        event.setLink( eventDTO.getLink() );
        event.setDescription( eventDTO.getDescription() );
        event.setHowToFindUs( eventDTO.getHowToFindUs() );
        event.setVisibility( eventDTO.getVisibility() );

        return event;
    }

    protected Venue venueDTOToVenue(VenueDTO venueDTO) {
        if ( venueDTO == null ) {
            return null;
        }

        Venue venue = new Venue();

        venue.setId( venueDTO.getId() );
        venue.setName( venueDTO.getName() );
        venue.setLatitude( venueDTO.getLatitude() );
        venue.setLongitude( venueDTO.getLongitude() );
        venue.setRePinned( venueDTO.isRePinned() );
        venue.setAddress1( venueDTO.getAddress1() );
        venue.setAddress2( venueDTO.getAddress2() );
        venue.setCity( venueDTO.getCity() );
        venue.setCountry( venueDTO.getCountry() );
        venue.setLocalizedCountryName( venueDTO.getLocalizedCountryName() );

        return venue;
    }

    protected Group groupDTOToGroup(GroupDTO groupDTO) {
        if ( groupDTO == null ) {
            return null;
        }

        Group group = new Group();

        group.setCreated( groupDTO.getCreated() );
        group.setName( groupDTO.getName() );
        group.setId( groupDTO.getId() );
        group.setJoinMode( groupDTO.getJoinMode() );
        group.setLatitude( groupDTO.getLatitude() );
        group.setLongitude( groupDTO.getLongitude() );
        group.setUrlName( groupDTO.getUrlName() );
        group.setWho( groupDTO.getWho() );
        group.setLocalizedLocation( groupDTO.getLocalizedLocation() );
        group.setRegion( groupDTO.getRegion() );

        return group;
    }
}
