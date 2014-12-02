package ch.studihome.jspserver.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ch.studihome.jspserver.model.Advert;

public interface AdvertDao extends CrudRepository<Advert,Long>
{
	Advert findByAdvId(Long id);
	
	@Query("SELECT f FROM Foo f WHERE LOWER(f.name) = LOWER(:name)")
	List<Advert> retrieveByName(@Param("name") String name);
}
