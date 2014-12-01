package ch.studihome.jspserver.model.pojos;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Email;

/**
 * Used to get the data from a Profile Form
 * 
 * @author TeamSiX
 */
public class ProfileForm {

    private String firstName;
    private String lastName;

    @NotNull
    @Email(message = "Must be valid email address")
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
