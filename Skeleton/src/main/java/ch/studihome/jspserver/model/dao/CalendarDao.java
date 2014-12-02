package ch.studihome.jspserver.model.dao;

import org.springframework.data.repository.CrudRepository;

import ch.studihome.jspserver.model.Advert;

public interface CalendarDao extends CrudRepository<Advert,Long> {

	Advert findByCalId(Long id);
}
