package org.sample.model.dao;

import org.sample.model.User;
import org.springframework.data.repository.CrudRepository;

public interface AdvertDao extends CrudRepository<User,Long> {
}
