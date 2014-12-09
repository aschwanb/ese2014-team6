package ch.studihome.jspserver.model.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Used to get the data from a ChangePassword Form
 * Only contains the password
 * 
 * @author TeamSiX
 */
public class ChangePasswordForm {

    @NotNull
    @Size(min = 6, message = "Password too short")
    private String password;
    
    @NotNull
    private String confirmPassword;
    
    public String getPassword() {
    	return password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
    
}
