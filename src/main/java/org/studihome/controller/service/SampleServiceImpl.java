package org.studihome.controller.service;

import org.studihome.controller.exceptions.InvalidUserException;
import org.studihome.controller.pojos.SignupForm;
import org.studihome.model.Address;
import org.studihome.model.User;
import org.studihome.model.dao.AddressDao;
import org.studihome.model.dao.UserDao;
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

        String firstName = signupForm.getFirstName();

        if(!StringUtils.isEmpty(firstName) && "ESE".equalsIgnoreCase(firstName)) {
            throw new InvalidUserException("Sorry, ESE is not a valid name");   // throw exception
        }


        Address address = new Address();
        address.setStreet("TestStreet-foo");
        
        User user = new User();
        user.setFirstName(signupForm.getFirstName());
        user.setEmail(signupForm.getEmail());
        user.setLastName(signupForm.getLastName());
        user.setAddress(address);
        
        user = userDao.save(user);   // save object to DB
        
        
        // Iterable<Address> addresses = addDao.findAll();  // find all 
        // Address anAddress = addDao.findOne((long)3); // find by ID
        
        
        signupForm.setId(user.getId());

        return signupForm;

    }
}
