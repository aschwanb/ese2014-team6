package ch.studihome.jspserver.model.dao;

import org.springframework.data.repository.CrudRepository;
import ch.studihome.jspserver.model.Address;


public interface AddressDao  extends CrudRepository<Address,Long>{

}
