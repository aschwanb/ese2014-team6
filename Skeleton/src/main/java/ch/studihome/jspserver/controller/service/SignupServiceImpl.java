package ch.studihome.jspserver.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import ch.studihome.jspserver.controller.exceptions.InvalidUserException;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AddressDao;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.ProfileForm;
import ch.studihome.jspserver.model.pojos.SignupForm;

/**
 * Implements SignupService using the Hibernate Daos
 * 
 * @author TeamSiX
 */
@Service
public class SignupServiceImpl implements SignupService {

    @Autowired    UserDao userDao;
    @Autowired    AddressDao addDao;
    
    public SignupServiceImpl() {}
    
    public SignupServiceImpl(UserDao userDao, AddressDao addDao)
    {
    	this.userDao = userDao;
    	this.addDao = addDao;
    }
    
    @Transactional
    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException
    {
    	String email = signupForm.getEmail();

        if(!StringUtils.isEmpty(email) && "ESE".equalsIgnoreCase(email)) {
            throw new InvalidUserException("Sorry, ESE is not a valid email");   // throw exception
        }
    
        User user = new User();
        user.setEmail(signupForm.getEmail());
        user.setPassword(signupForm.getPassword());
        user.setUserName(signupForm.getUserName());
        user.setFirstName(signupForm.getFirstName());
        user.setLastName(signupForm.getLastName());
        user.setUser_role("ROLE_USER");
        user.setEnabled("TRUE");  
        user = userDao.save(user);         // save object to DB
        
        signupForm.setId(user.getusrId());
        return signupForm;

    }
    
    @Transactional
    public ProfileForm updateFrom(ProfileForm profileForm, User user) throws InvalidUserException
    {
    	String email = profileForm.getEmail();

        if(!StringUtils.isEmpty(email) && "ESE".equalsIgnoreCase(email)) {
            throw new InvalidUserException("Sorry, ESE is not a valid email");   // throw exception
        }
    
        user.setEmail(profileForm.getEmail());
        user.setFirstName(profileForm.getFirstName());
        user.setLastName(profileForm.getLastName());
        user = userDao.save(user);         // save object to DB
        
        return profileForm;

    }
    
    @Transactional
    public void changePasswordFrom(String password, User user)
    {
        user.setPassword(password);
        user = userDao.save(user);         // save object to DB
    }
}
