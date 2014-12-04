package ch.studihome.jspserver.controller;

import java.util.Date;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.model.Address;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.RoomImg;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AddressDao;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.AlertDao;
import ch.studihome.jspserver.model.dao.CalendarDao;
import ch.studihome.jspserver.model.dao.EventDao;
import ch.studihome.jspserver.model.dao.InviteDao;
import ch.studihome.jspserver.model.dao.MessageDao;
import ch.studihome.jspserver.model.dao.RoomImgDao;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.BSalert;

/**
 * Load and return index view 
 * 
 * @author TeamSix
 */
@Controller
public class ResetDBController
{
	@Autowired
	UserDao userDao;
	
	@Autowired
	AdvertDao advertDao;
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	CalendarDao calendarDao;
	
	@Autowired
	EventDao eventDao;
	
	@Autowired
	InviteDao inviteDao;
	
	@Autowired
	InviteDao alertDao;
	
	@Autowired
	MessageDao messageDao;
	
	@Autowired
	RoomImgDao roomImgDao;
	
	/**
     * 
     * @return Index view
     */
	@RequestMapping(value = { "/resetDatabase" })
    public ModelAndView index(@RequestParam(value = "o", required = false)String password, @RequestParam(value = "p", required = false)String repopulate)
	{
    	ModelAndView model;
    	
    	if(password != null && password.equals("fuckthisshit"))
    	{
	    	model = new ModelAndView("resetDBPage");
	
			clearDatabase();
			
			if(repopulate != null)
			{
				loadInitialData();
			}
	    	
	    	BSalert[] alerts = new BSalert[1];
			alerts[0] = new BSalert(BSalert.Type.success, "Database reset.");
			model.addObject("alerts", alerts);
    	}else
    	{
    		model = new ModelAndView("resetDBPage");
    		
    		if(password != null)
    		{
    			BSalert[] alerts = new BSalert[1];
    			alerts[0] = new BSalert(BSalert.Type.danger, "Wrong password.");
    			model.addObject("alerts", alerts);
    		}
    	}
    	
    	return model;
    	
    }
	
	private void clearDatabase()
	{
		//TODO following code may break if now broken code is running. In that case reordering may solve the issue
		
		advertDao.deleteAll();
		addressDao.deleteAll();
		userDao.deleteAll();
		
		alertDao.deleteAll();
		calendarDao.deleteAll();
		eventDao.deleteAll();
		inviteDao.deleteAll();
		messageDao.deleteAll();
	}
	
	private void loadInitialData()
	{
		createUsers();
    	createAdverts();
	}
	
	private void createAdverts()
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
		advert11.setAddress(new Address("Bachstrasse 257", "3078", "Richigen", "46.914300672708904, 7.582427300022346", advert11));
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
		advert12.setAddress(new Address("Bachstrasse 256", "3078", "Richigen", "46.9161812, 7.583259699999985", advert12));
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
		advert13.setAddress(new Address("Bachstrasse 255", "3078", "Richigen", "46.9162083, 7.58312849999993", advert13));
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
		advert21.setAddress(new Address("Bachstrasse 254", "3078", "Richigen", "46.9156506, 7.58312699999999", advert21));
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
		advert22.setAddress(new Address("Bachstrasse 253", "3078", "Richigen", "46.9159383, 7.583219699999972", advert22));
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
		advert23.setAddress(new Address("Bachstrasse 252", "3078", "Richigen", "46.9164693, 7.582984799999963", advert23));
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
		
		HashSet<Advert> adverts3 = new HashSet<Advert>();
		User user3 = userDao.findByUserName("Trinity");
		
		Advert advert31 = new Advert();
		advert31.setAppartementSize(110);
		advert31.setDescription("It looks nice and is clean");
		advert31.setIsWG(true);
		advert31.setNumberOfInhabitants(4);
		advert31.setNumberOfRooms(5);
		advert31.setPrice(400);
		advert31.setRoomSize(20);
		advert31.setTimeAndDate(new Date().getTime());
		advert31.setTitle("5 room apartment");
		advert31.setAddress(new Address("Bachstrasse 251", "3078", "Richigen", "46.9158938, 7.58283890000007", advert31));
		advert31.setUser(user3);
		RoomImg roomImg31 = new RoomImg();
		roomImg31.setAdvert(advert31);
		roomImg31.setImgDescription("Nice Image");
		roomImg31.setImgName("niceImage.jpg");
		roomImg31.setImgNum(1);
		HashSet<RoomImg> roomImgs31 = new HashSet<RoomImg>();
		roomImgs31.add(roomImg31);
		advert31.setImgs(roomImgs31);
		advertDao.save(advert31);
		adverts3.add(advert31);

		Advert advert32 = new Advert();
		advert32.setAppartementSize(100);
		advert32.setDescription("It looks nice and is clean");
		advert32.setIsWG(true);
		advert32.setNumberOfInhabitants(3);
		advert32.setNumberOfRooms(4);
		advert32.setPrice(350);
		advert32.setRoomSize(20);
		advert32.setTimeAndDate(new Date().getTime());
		advert32.setTitle("4 room apartment");
		advert32.setAddress(new Address("Bachstrasse 250", "3078", "Richigen", "46.9160475, 7.582235399999945", advert32));
		advert32.setUser(user3);
		RoomImg roomImg32 = new RoomImg();
		roomImg32.setAdvert(advert32);
		roomImg32.setImgDescription("Nice Image");
		roomImg32.setImgName("niceImage.jpg");
		roomImg32.setImgNum(1);
		HashSet<RoomImg> roomImgs32 = new HashSet<RoomImg>();
		roomImgs32.add(roomImg32);
		advert32.setImgs(roomImgs32);
		advertDao.save(advert32);
		adverts3.add(advert32);
		
		Advert advert33 = new Advert();
		advert33.setAppartementSize(90);
		advert33.setDescription("It looks nice and is clean");
		advert33.setIsWG(false);
		advert33.setNumberOfInhabitants(1);
		advert33.setNumberOfRooms(4);
		advert33.setPrice(1200);
		advert33.setRoomSize(0);
		advert33.setTimeAndDate(new Date().getTime());
		advert33.setTitle("Single apartment");
		advert33.setAddress(new Address("Bachstrasse 249", "3078", "Richigen", "46.9162988, 7.582708700000012", advert33));
		advert33.setUser(user3);
		RoomImg roomImg33 = new RoomImg();
		roomImg33.setAdvert(advert33);
		roomImg33.setImgDescription("Nice Image");
		roomImg33.setImgName("niceImage.jpg");
		roomImg33.setImgNum(1);
		HashSet<RoomImg> roomImgs33 = new HashSet<RoomImg>();
		roomImgs33.add(roomImg33);
		advert33.setImgs(roomImgs33);
		advertDao.save(advert33);
		adverts3.add(advert33);
		
		user3.setAds(adverts3);
		userDao.save(user3);
		
		HashSet<Advert> adverts4 = new HashSet<Advert>();
		User user4 = userDao.findByUserName("AgentSmith");
		
		Advert advert41 = new Advert();
		advert41.setAppartementSize(110);
		advert41.setDescription("It looks nice and is clean");
		advert41.setIsWG(true);
		advert41.setNumberOfInhabitants(4);
		advert41.setNumberOfRooms(5);
		advert41.setPrice(400);
		advert41.setRoomSize(20);
		advert41.setTimeAndDate(new Date().getTime());
		advert41.setTitle("5 room apartment");
		advert41.setAddress(new Address("Bachstrasse 248", "3078", "Richigen", "46.917032, 7.582481599999937", advert41));
		advert41.setUser(user4);
		RoomImg roomImg41 = new RoomImg();
		roomImg41.setAdvert(advert41);
		roomImg41.setImgDescription("Nice Image");
		roomImg41.setImgName("niceImage.jpg");
		roomImg41.setImgNum(1);
		HashSet<RoomImg> roomImgs41 = new HashSet<RoomImg>();
		roomImgs41.add(roomImg41);
		advert41.setImgs(roomImgs41);
		advertDao.save(advert41);
		adverts4.add(advert41);

		Advert advert42 = new Advert();
		advert42.setAppartementSize(100);
		advert42.setDescription("It looks nice and is clean");
		advert42.setIsWG(true);
		advert42.setNumberOfInhabitants(3);
		advert42.setNumberOfRooms(4);
		advert42.setPrice(350);
		advert42.setRoomSize(20);
		advert42.setTimeAndDate(new Date().getTime());
		advert42.setTitle("4 room apartment");
		advert42.setAddress(new Address("Bachstrasse 247", "3078", "Richigen", "46.9165626, 7.58155940000006", advert42));
		advert42.setUser(user4);
		RoomImg roomImg42 = new RoomImg();
		roomImg42.setAdvert(advert42);
		roomImg42.setImgDescription("Nice Image");
		roomImg42.setImgName("niceImage.jpg");
		roomImg42.setImgNum(1);
		HashSet<RoomImg> roomImgs42 = new HashSet<RoomImg>();
		roomImgs42.add(roomImg42);
		advert42.setImgs(roomImgs42);
		advertDao.save(advert42);
		adverts4.add(advert42);
		
		Advert advert43 = new Advert();
		advert43.setAppartementSize(90);
		advert43.setDescription("It looks nice and is clean");
		advert43.setIsWG(false);
		advert43.setNumberOfInhabitants(1);
		advert43.setNumberOfRooms(4);
		advert43.setPrice(1200);
		advert43.setRoomSize(0);
		advert43.setTimeAndDate(new Date().getTime());
		advert43.setTitle("Single apartment");
		advert43.setAddress(new Address("Bachstrasse 246", "3078", "Richigen", "46.9167052, 7.581357600000047", advert43));
		advert43.setUser(user4);
		RoomImg roomImg43 = new RoomImg();
		roomImg43.setAdvert(advert43);
		roomImg43.setImgDescription("Nice Image");
		roomImg43.setImgName("niceImage.jpg");
		roomImg43.setImgNum(1);
		HashSet<RoomImg> roomImgs43 = new HashSet<RoomImg>();
		roomImgs43.add(roomImg43);
		advert43.setImgs(roomImgs43);
		advertDao.save(advert43);
		adverts4.add(advert43);
		
		user4.setAds(adverts4);
		userDao.save(user4);
	}
	
	private void createUsers()
	{
		
		User user1 = new User();
		user1.setUserName("Neo");
		user1.setUser_role("ROLE_USER");
		user1.setPassword("itisnotreal");
		user1.setLastName("Reeves");
		user1.setFirstName("Keanu");
		user1.setEmail("keanu.reeves@neo.com");
		user1.setEnabled("true");
		userDao.save(user1);
		
		User user2 = new User();
		user2.setUserName("Morpheus");
		user2.setUser_role("ROLE_USER");
		user2.setPassword("itisnotreal");
		user2.setLastName("Fishburne");
		user2.setFirstName("Laurence");
		user2.setEmail("laurence.fishburne@morpheus.com");
		user2.setEnabled("true");
		userDao.save(user2);
		
		User user3 = new User();
		user3.setUserName("Trinity");
		user3.setUser_role("ROLE_USER");
		user3.setPassword("itisnotreal");
		user3.setLastName("Moss");
		user3.setFirstName("Carrie-Anne");
		user3.setEmail("carrie-anne.moss@trinity.com");
		user3.setEnabled("true");
		userDao.save(user3);
		
		User user4 = new User();
		user4.setUserName("AgentSmith");
		user4.setUser_role("ROLE_USER");
		user4.setPassword("yesitis");
		user4.setLastName("Weaving");
		user4.setFirstName("Hugo");
		user4.setEmail("hugo.weaving@agentsmith.com");
		user4.setEnabled("true");
		userDao.save(user4);
	}

}


