package ch.studihome.jspserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfilepageController {

    @RequestMapping(value = "/profilepage", method = RequestMethod.GET)
    public ModelAndView index() {
    	ModelAndView model = new ModelAndView("profilepage");
    	return model;
    }

}


