package ch.studihome.jspserver.model.dao;

import org.springframework.data.repository.CrudRepository;

import ch.studihome.jspserver.model.User;

public interface UserDao extends CrudRepository<User,Long> {
}
