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
 * Load and return profile view
 * Handle profile modification and password changes
 * Detailed views for calendar, adverts et al are handled
 * in detaild controllers 
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
	 * Returns the requested profile view
	 * profile, profile_edit or profile_changePswd
	 * 
	 * @param editProfile	set if profile_edit is requested
	 * @param changePassword set if profile_changePswd is requested
	 * @return the profile page model
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
	 * Changes the profile info according to the data in profileForm
	 * 
	 * @param profileForm
	 * @param result	object passed by Spring to detect faulty input
	 * @return	profile model
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
	 * Update password according to data in changePasswordForm
	 * 
	 * @param changePasswordForm	password data
	 * @param result	object passed by Spring to detect faulty input
	 * @return	profile model
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


