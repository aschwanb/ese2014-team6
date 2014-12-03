package ch.studihome.jspserver.model.dao;

import org.springframework.data.repository.CrudRepository;

import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Event;

public interface EventDao extends CrudRepository<Event,Long> {

	Event findByEventId(Long id);
}
