package ch.studihome.jspserver.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.studihome.jspserver.model.Message;
import ch.studihome.jspserver.model.User;

public interface MessageDao extends CrudRepository<Message,Long> {

	Message findById(Long id);
	User findByFromUser(User user);
	User findByToUser(User user);
	
}
