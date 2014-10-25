package org.sample.controller.service;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.controller.pojos.SignupForm;
import org.sample.model.Address;
import org.sample.model.User;
import org.sample.model.dao.AddressDao;
import org.sample.model.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service
public class SampleServiceImpl implements SampleService {

    @Autowired    UserDao userDao;
    @Autowired    AddressDao addDao;
    
    @Transactional
    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException{

//        String firstName = signupForm.getFirstName();
    	String email = signupForm.getEmail();

        if(!StringUtils.isEmpty(email) && "ESE".equalsIgnoreCase(email)) {
            throw new InvalidUserException("Sorry, ESE is not a valid email");   // throw exception
        }


        Address address = new Address();
        address.setStreet("TestStreet-foo");
        
        User user = new User();
//        user.setFirstName(signupForm.getFirstName());
        user.setEmail(signupForm.getEmail());
        user.setUserName(signupForm.getUserName());
//        user.setLastName(signupForm.getLastName());
        user.setAddress(address);
        user.setPassword(signupForm.getPassword());
        user.setUser_role("ROLE_USER");
        user.setEnabled("TRUE");
        
        user = userDao.save(user);   // save object to DB
        
        
        // Iterable<Address> addresses = addDao.findAll();  // find all 
        // Address anAddress = addDao.findOne((long)3); // find by ID
        
        
        signupForm.setId(user.getId());

        return signupForm;

    }
}
