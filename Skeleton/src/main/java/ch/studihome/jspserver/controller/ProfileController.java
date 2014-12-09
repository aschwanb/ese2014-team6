package ch.studihome.jspserver.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.service.MyUserDetailsService;
import ch.studihome.jspserver.controller.service.SignupService;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.BSalert;
import ch.studihome.jspserver.model.pojos.ChangePasswordForm;
import ch.studihome.jspserver.model.pojos.ProfileForm;

/**
 * Load and return user profile view 
 * 
 * @author TeamSix
 */
@Controller
public class ProfileController {
	
	@Autowired UserDao usrDao;
	@Autowired SignupService signupService;
	@Autowired MyUserDetailsService userService;
	
	public ProfileController() {}
		
    public ProfileController(UserDao usrDao, SignupService signupService, MyUserDetailsService userService)
    {
		this.usrDao = usrDao;
		this.signupService = signupService;
		this.userService = userService;
	}

	/**
	 * @return Profile view
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(value = "edit", required=false)String editProfile, @RequestParam(value = "changePswd", required=false)String changePassword)
    {
		ModelAndView model;
		
		if(editProfile != null)
		{
	    	model = new ModelAndView("profile_edit");
		}else if(changePassword != null)
		{
	    	model = new ModelAndView("profile_changePswd");
		}else
		{
	    	model = new ModelAndView("profile");
		}
    	
    	User user = userService.getUser();
    	model.addObject("user", user);
    	
    	if(changePassword == null)
    	{
	    	ProfileForm profileForm = new ProfileForm();
	    	
	    	profileForm.setEmail(user.getEmail());
	    	profileForm.setFirstName(user.getFirstName());
	    	profileForm.setLastName(user.getLastName());
	    	
	    	model.addObject("profileForm", profileForm);
    	}else
    	{
    		model.addObject("changePasswordForm", new ChangePasswordForm());
    	}
    	
    	return model;
    }
	
	/**
	 * @return Profile view
	 */
	@RequestMapping(value = "/updateprofile")
    public ModelAndView update(@Valid ProfileForm profileForm, BindingResult result)
    {
		ModelAndView model;

		User user = userService.getUser();
		
		if (result.hasErrors())
		{
			model = new ModelAndView("profile_edit");
	    	model.addObject("user", user);
	    	model.addObject("profileForm", profileForm);
		}else
		{
			model = new ModelAndView("profile");
			
	    	signupService.updateFrom(profileForm, user);

	    	model.addObject("user", user);
	    	model.addObject("profileForm", profileForm);
	    	
	    	BSalert[] alerts = new BSalert[1];
	    	alerts[0] = new BSalert(BSalert.Type.success, "Profile data successfully changed.");
	    	model.addObject("alerts", alerts);
		}
    	return model;
    }
	
	/**
	 * @return Profile view
	 */
	@RequestMapping(value = "/changepassword")
    public ModelAndView changePswd(@Valid ChangePasswordForm changePasswordForm, BindingResult result)
    {
		ModelAndView model;
		
		User user = userService.getUser();
		
		if (!changePasswordForm.getPassword().equals(changePasswordForm.getConfirmPassword()))
		{
			model = new ModelAndView("profile_changePswd");
	    	model.addObject("user", user);
	    	
	    	BSalert[] alerts = new BSalert[1];
	    	alerts[0] = new BSalert(BSalert.Type.danger, "Passwords not matching");
	    	model.addObject("alerts", alerts);
    	}else if (result.hasErrors())
    	{
    		model = new ModelAndView("profile_changePswd");
	    	model.addObject("user", user);
        }else
        {
			model = new ModelAndView("profile");
	    	model.addObject("user", user);
			
        	signupService.changePasswordFrom(changePasswordForm.getPassword(), user);

	    	ProfileForm profileForm = new ProfileForm();
	    	profileForm.setEmail(user.getEmail());
	    	profileForm.setFirstName(user.getFirstName());
	    	profileForm.setLastName(user.getLastName());
	    	model.addObject("profileForm", profileForm);
	    	
        	BSalert[] alerts = new BSalert[1];
        	alerts[0] = new BSalert(BSalert.Type.success, "Password changed.");
        	model.addObject("alerts", alerts);
        }
		
    	return model;
    }

}


