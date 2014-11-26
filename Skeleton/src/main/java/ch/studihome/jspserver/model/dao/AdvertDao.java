package ch.studihome.jspserver.model.dao;

import org.springframework.data.repository.CrudRepository;

import ch.studihome.jspserver.model.Advert;

public interface AdvertDao extends CrudRepository<Advert,Long> {

	Advert findByAdvId(Long id);
}
