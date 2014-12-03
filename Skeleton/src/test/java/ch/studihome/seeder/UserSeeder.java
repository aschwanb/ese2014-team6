package ch.studihome.seeder;

import org.springframework.beans.factory.annotation.Autowired;

import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.UserDao;

public class UserSeeder
{
	@Autowired
	UserDao userDao;
	
	public void createUsers()
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
