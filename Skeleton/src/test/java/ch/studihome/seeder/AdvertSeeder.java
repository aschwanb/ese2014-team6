package ch.studihome.seeder;

import org.springframework.beans.factory.annotation.Autowired;

import ch.studihome.jspserver.model.Advert;
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
		Advert advert1 = new Advert();
		
	}
}
