package org.studihome.model.dao;

import org.studihome.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Long> {
}
