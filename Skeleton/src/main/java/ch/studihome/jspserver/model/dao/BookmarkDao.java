package ch.studihome.jspserver.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Bookmark;
import ch.studihome.jspserver.model.User;

public interface BookmarkDao extends CrudRepository<Bookmark,Long> 
{
	Bookmark findByBmId(Long id);
	Bookmark findByAdvertAndUser(Advert advert, User user);
	List<Bookmark> findByAdvert(Advert advert);
	List<Bookmark> findByUser(User user);
}
