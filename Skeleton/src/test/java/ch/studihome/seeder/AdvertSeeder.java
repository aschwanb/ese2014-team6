package ch.studihome.seeder;

import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;

import ch.studihome.jspserver.model.Address;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.RoomImg;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.UserDao;

public class AdvertSeeder
{
	@Autowired
	UserDao userDao;
	
	@Autowired
	AdvertDao advertDao;
	
	public void createAdverts()
	{
		HashSet<Advert> adverts1 = new HashSet<Advert>();
		User user1 = userDao.findByUserName("Neo");
		
		Advert advert11 = new Advert();
		advert11.setAppartementSize(110);
		advert11.setDescription("It looks nice and is clean");
		advert11.setIsWG(true);
		advert11.setNumberOfInhabitants(4);
		advert11.setNumberOfRooms(5);
		advert11.setPrice(400);
		advert11.setRoomSize(20);
		advert11.setTimeAndDate(new Date().getTime());
		advert11.setTitle("5 room apartment");
		advert11.setAddress(new Address("Bachstrasse 257", "3078", "Richigen", "46.914300672708904, 7.582427300022346"));
		advert11.setUser(user1);
		RoomImg roomImg11 = new RoomImg();
		roomImg11.setAdvert(advert11);
		roomImg11.setImgDescription("Nice Image");
		roomImg11.setImgName("niceImage.jpg");
		roomImg11.setImgNum(1);
		HashSet<RoomImg> roomImgs11 = new HashSet<RoomImg>();
		roomImgs11.add(roomImg11);
		advert11.setImgs(roomImgs11);
		advertDao.save(advert11);
		adverts1.add(advert11);

		Advert advert12 = new Advert();
		advert12.setAppartementSize(100);
		advert12.setDescription("It looks nice and is clean");
		advert12.setIsWG(true);
		advert12.setNumberOfInhabitants(3);
		advert12.setNumberOfRooms(4);
		advert12.setPrice(350);
		advert12.setRoomSize(20);
		advert12.setTimeAndDate(new Date().getTime());
		advert12.setTitle("4 room apartment");
		advert12.setAddress(new Address("Bachstrasse 256", "3078", "Richigen", "46.9161812, 7.583259699999985"));
		advert12.setUser(user1);
		RoomImg roomImg12 = new RoomImg();
		roomImg12.setAdvert(advert12);
		roomImg12.setImgDescription("Nice Image");
		roomImg12.setImgName("niceImage.jpg");
		roomImg12.setImgNum(1);
		HashSet<RoomImg> roomImgs12 = new HashSet<RoomImg>();
		roomImgs12.add(roomImg12);
		advert12.setImgs(roomImgs12);
		advertDao.save(advert12);
		adverts1.add(advert12);
		
		Advert advert13 = new Advert();
		advert13.setAppartementSize(90);
		advert13.setDescription("It looks nice and is clean");
		advert13.setIsWG(false);
		advert13.setNumberOfInhabitants(1);
		advert13.setNumberOfRooms(4);
		advert13.setPrice(1200);
		advert13.setRoomSize(0);
		advert13.setTimeAndDate(new Date().getTime());
		advert13.setTitle("Single apartment");
		advert13.setAddress(new Address("Bachstrasse 255", "3078", "Richigen", "46.9162083, 7.58312849999993"));
		advert13.setUser(user1);
		RoomImg roomImg13 = new RoomImg();
		roomImg13.setAdvert(advert13);
		roomImg13.setImgDescription("Nice Image");
		roomImg13.setImgName("niceImage.jpg");
		roomImg13.setImgNum(1);
		HashSet<RoomImg> roomImgs13 = new HashSet<RoomImg>();
		roomImgs13.add(roomImg13);
		advert13.setImgs(roomImgs13);
		advertDao.save(advert13);
		adverts1.add(advert13);
		
		user1.setAds(adverts1);
		userDao.save(user1);
		
		HashSet<Advert> adverts2 = new HashSet<Advert>();
		User user2 = userDao.findByUserName("Morpheus");
		
		Advert advert21 = new Advert();
		advert21.setAppartementSize(110);
		advert21.setDescription("It looks nice and is clean");
		advert21.setIsWG(true);
		advert21.setNumberOfInhabitants(4);
		advert21.setNumberOfRooms(5);
		advert21.setPrice(400);
		advert21.setRoomSize(20);
		advert21.setTimeAndDate(new Date().getTime());
		advert21.setTitle("5 room apartment");
		advert21.setAddress(new Address("Bachstrasse 254", "3078", "Richigen", "46.9156506, 7.58312699999999"));
		advert21.setUser(user2);
		RoomImg roomImg21 = new RoomImg();
		roomImg21.setAdvert(advert21);
		roomImg21.setImgDescription("Nice Image");
		roomImg21.setImgName("niceImage.jpg");
		roomImg21.setImgNum(1);
		HashSet<RoomImg> roomImgs21 = new HashSet<RoomImg>();
		roomImgs21.add(roomImg21);
		advert21.setImgs(roomImgs21);
		advertDao.save(advert21);
		adverts2.add(advert21);

		Advert advert22 = new Advert();
		advert22.setAppartementSize(100);
		advert22.setDescription("It looks nice and is clean");
		advert22.setIsWG(true);
		advert22.setNumberOfInhabitants(3);
		advert22.setNumberOfRooms(4);
		advert22.setPrice(350);
		advert22.setRoomSize(20);
		advert22.setTimeAndDate(new Date().getTime());
		advert22.setTitle("4 room apartment");
		advert22.setAddress(new Address("Bachstrasse 253", "3078", "Richigen", "46.9159383, 7.583219699999972"));
		advert22.setUser(user2);
		RoomImg roomImg22 = new RoomImg();
		roomImg22.setAdvert(advert22);
		roomImg22.setImgDescription("Nice Image");
		roomImg22.setImgName("niceImage.jpg");
		roomImg22.setImgNum(1);
		HashSet<RoomImg> roomImgs22 = new HashSet<RoomImg>();
		roomImgs22.add(roomImg22);
		advert22.setImgs(roomImgs22);
		advertDao.save(advert22);
		adverts2.add(advert22);
		
		Advert advert23 = new Advert();
		advert23.setAppartementSize(90);
		advert23.setDescription("It looks nice and is clean");
		advert23.setIsWG(false);
		advert23.setNumberOfInhabitants(1);
		advert23.setNumberOfRooms(4);
		advert23.setPrice(1200);
		advert23.setRoomSize(0);
		advert23.setTimeAndDate(new Date().getTime());
		advert23.setTitle("Single apartment");
		advert23.setAddress(new Address("Bachstrasse 252", "3078", "Richigen", "46.9164693, 7.582984799999963"));
		advert23.setUser(user2);
		RoomImg roomImg23 = new RoomImg();
		roomImg23.setAdvert(advert23);
		roomImg23.setImgDescription("Nice Image");
		roomImg23.setImgName("niceImage.jpg");
		roomImg23.setImgNum(1);
		HashSet<RoomImg> roomImgs23 = new HashSet<RoomImg>();
		roomImgs23.add(roomImg23);
		advert23.setImgs(roomImgs23);
		advertDao.save(advert23);
		adverts2.add(advert23);
		
		user2.setAds(adverts2);
		userDao.save(user2);
	}
}
