package ch.studihome.jspserver.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


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
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((enabled == null) ? 0 : enabled.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		result = prime * result
				+ ((user_role == null) ? 0 : user_role.hashCode());
		result = prime * result + ((usr_id == null) ? 0 : usr_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null)
		{
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enabled == null)
		{
			if (other.enabled != null)
				return false;
		} else if (!enabled.equals(other.enabled))
			return false;
		if (firstName == null)
		{
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null)
		{
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null)
		{
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null)
		{
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (user_role == null)
		{
			if (other.user_role != null)
				return false;
		} else if (!user_role.equals(other.user_role))
			return false;
		if (usr_id == null)
		{
			if (other.usr_id != null)
				return false;
		} else if (!usr_id.equals(other.usr_id))
			return false;
		return true;
	}

	
}
