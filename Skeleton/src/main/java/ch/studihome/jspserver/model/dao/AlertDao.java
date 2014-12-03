package ch.studihome.jspserver.model.dao;

import org.springframework.data.repository.CrudRepository;

import ch.studihome.jspserver.model.Alert;

public interface AlertDao extends CrudRepository<Alert,Long> 
{
	Alert findByAdvId(Long id);
}
