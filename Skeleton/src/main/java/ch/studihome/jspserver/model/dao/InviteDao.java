package ch.studihome.jspserver.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.studihome.jspserver.model.Invite;
import ch.studihome.jspserver.model.Message;
import ch.studihome.jspserver.model.User;

public interface InviteDao extends CrudRepository<Invite,Long> {

	Invite findById(Long id);
	Iterable<Invite> findAll();

// Not needed? -> user.getFromMsg/ToMsg()
//	Iterable<Invite> findByFromUser(User user);
//	Iterable<Invite> findByToUser(User user);
	
}
