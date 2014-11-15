package ch.studihome.jspserver.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.UserRole;

public interface UserRoleDao extends CrudRepository<UserRole,Long> {

}
