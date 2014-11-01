package org.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MapController {

	@RequestMapping(value = "/map", method = RequestMethod.GET)
    public ModelAndView index() {
    	ModelAndView model = new ModelAndView("map");
    	return model;
    }

}


