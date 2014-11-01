package org.sample.controller;

import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.model.pojos.SignupForm;
import org.sample.controller.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController {

    @Autowired
    SignupService sampleService;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public ModelAndView index() {
    	ModelAndView model = new ModelAndView("index");
    	return model;
    }

}


