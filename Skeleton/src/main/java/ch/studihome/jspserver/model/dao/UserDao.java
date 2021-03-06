package ch.studihome.jspserver.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.studihome.jspserver.model.User;

public interface UserDao extends CrudRepository<User,Long> {
	List<User> findByEmail(String email);
	// Implementation for spring security
	User findByUserName(String username);
	User findByUsrId(Long id);
}
