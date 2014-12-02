package ch.studihome.jspserver.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ch.studihome.jspserver.model.Advert;

public interface AdvertDao extends CrudRepository<Advert,Long>
{
	Advert findByAdvId(Long id);
	
	@Query("SELECT a FROM Advert a JOIN a.address adr WHERE "
			+ "a.price BETWEEN :min_price and :max_price AND"
			+ "a.roomSize BETWEEN :min_room_size and :max_room_size AND"
			+ "a.appartementSize BETWEEN :min_appartment_size and :max_appartment_size AND"
			+ "a.numberOfInhabitants BETWEEN : min_number_of_inhabitants and :max_number_of_inhabitants AND"
			+ "(adr.city like :area OR adr.plz like :area OR adr.street like :area) AND"
			+ "a.isWG is :type_of_appartment"
			+ "a.timeAndDate >= :timeAndDate")
	List<Advert> findFiltered(@Param("min_price") int min_price,
								@Param("max_price") int max_price,
								@Param("min_room_size") int min_room_size,
								@Param("max_room_size") int max_roo_size,
								@Param("min_appartment_size") int min_appartment_size,
								@Param("max_appartment_size") int max_appartment_size,
								@Param("min_number_of_inhabitants") int min_number_of_inhabitants,
								@Param("max_number_of_inhabitants") int max_number_of_inhabitants,
								@Param("area") String area,
								@Param("type_of_appartment") boolean type_of_appartment,
								@Param("timeAndDate") long timeAndDate);
}
