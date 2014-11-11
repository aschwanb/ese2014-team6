package ch.studihome.jspserver.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import ch.studihome.jspserver.controller.exceptions.InvalidUserException;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AddressDao;
import ch.studihome.jspserver.model.dao.UserDao;
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
    
    @Transactional
    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException{

//        String firstName = signupForm.getFirstName();
    	String email = signupForm.getEmail();

        if(!StringUtils.isEmpty(email) && "ESE".equalsIgnoreCase(email)) {
            throw new InvalidUserException("Sorry, ESE is not a valid email");   // throw exception
        }


        //Address address = new Address();
        //address.setStreet("TestStreet-foo");
        
        User user = new User();
//        user.setFirstName(signupForm.getFirstName());
        user.setEmail(signupForm.getEmail());
//        user.setUserName(signupForm.getUserName());
//        user.setLastName(signupForm.getLastName());
        //user.setAddress(address);
        user.setPassword(signupForm.getPassword());
        user.setUser_role("ROLE_USER");
        user.setEnabled("TRUE");
        
        user = userDao.save(user);   // save object to DB
        
        
        // Iterable<Address> addresses = addDao.findAll();  // find all 
        // Address anAddress = addDao.findOne((long)3); // find by ID
        
        
        signupForm.setId(user.getUsr_id());

        return signupForm;

    }
}
