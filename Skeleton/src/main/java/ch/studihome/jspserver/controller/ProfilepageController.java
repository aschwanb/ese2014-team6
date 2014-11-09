package ch.studihome.jspserver.controller;

import java.security.Principal;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.UserDao;

@Controller
public class ProfilepageController {

    @Autowired UserDao usrDao;

    @RequestMapping(value = "/profilepage", method = RequestMethod.GET)
//    public ModelAndView index(@RequestParam Principal principal) {
    public ModelAndView index() {
    ModelAndView model = new ModelAndView("profilepage");
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username = ((UserDetails)principal).getUsername();
    User user = usrDao.findByEmail(username).get(0);
    
    Set<Advert> ads = user.getAds();
    model.addObject("ads", ads);
    
    return model;
    }

}


