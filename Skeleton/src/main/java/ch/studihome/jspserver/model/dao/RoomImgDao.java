package ch.studihome.jspserver.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.RoomImg;
import ch.studihome.jspserver.model.User;

public interface RoomImgDao  extends CrudRepository<RoomImg,Long>{
	List<RoomImg> findByAdvertAndImgNum(Advert adv, int imgNum);
}