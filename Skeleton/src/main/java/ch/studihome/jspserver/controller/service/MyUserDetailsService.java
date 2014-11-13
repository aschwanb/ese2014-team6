package ch.studihome.jspserver.controller.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ch.studihome.jspserver.controller.AdvertController;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.UserDao;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired UserDao userDao;
	static Logger log = Logger.getLogger(AdvertController.class.getName());

	public User loadUserByUsername(String userName) throws UsernameNotFoundException {
		log.info("User Details Service for username " + userName + "!");
		User user = userDao.findByEmail(userName).get(0);
		log.info("Generated new user object with: " + user.toString());
		
		return user;
	}

}
