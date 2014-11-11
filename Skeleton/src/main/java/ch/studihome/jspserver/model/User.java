package ch.studihome.jspserver.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Object representing a user of our web service
 * 
 * For first registratin, only the following paramters are necessar:
 * email, password, user_role, enabled
 * 
 * user_role and enabled are not set by the user
 * 
 * @author TeamSix
 *
 */

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long usr_id;

    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String user_role;
    private String enabled;
    
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="user")
    private Set<Advert> ads = new HashSet<Advert>(0);
    
    public String toString() {
    	String out = "FirstName: " + firstName + "\n"+
    			"LastName: " + lastName + "\n"+
    			"UserName: " + userName + "\n"+
    			"Email: " + email + "\n"+
    			"Password: " + password + "\n"+
    			"UserRole: " + user_role + "\n"+
    			"Enabled: " + enabled + "\n";
    	return out;
    }
    public Long getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(Long id) {
        this.usr_id = id;
    }

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String username) {
		this.userName = username;
	}

	public String getUser_role() {
		return user_role;
	}

	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public Set<Advert> getAds() {
		return ads;
	}

	public void setAds(Set<Advert> ads) {
		this.ads = ads;
	}

	
}
