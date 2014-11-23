package ch.studihome.jspserver.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class User implements UserDetails {

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
    
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="fromUser")
    private Set<Message> fromMsgs = new HashSet<Message>(0);

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="toUser")
    private Set<Message> toMsgs = new HashSet<Message>(0);
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "bookmarklist",
			   joinColumns = { @JoinColumn(name = "usr_id", nullable = false, updatable = false) }, 
			   inverseJoinColumns = { @JoinColumn(name = "adv_id", nullable = false, updatable = false) })
	private Set<Advert> bookmarks = new HashSet<Advert>(0);
	
	public Set<Message> getFromMsgs() {
		return fromMsgs;
	}
	public void setFromMsgs(Set<Message> fromMsgs) {
		this.fromMsgs = fromMsgs;
	}
	public Set<Message> getToMsgs() {
		return toMsgs;
	}
	public void setToMsgs(Set<Message> toMsgs) {
		this.toMsgs = toMsgs;
	}

	public String toString() {
    	String out = "FirstName: " + firstName + "\n"+
    			"LastName: " + lastName + "\n"+
    			"UserName: " + userName + "\n"+
    			"Email: " + email + "\n"+
    			"Password: " + password + "\n"+
    			"UserRole: " + user_role + "\n"+
    			"Enabled: " + enabled + "\n" +
    			"GrantedAuthority: " + this.getAuthorities().iterator().next().toString();
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

	public void setUserName(String userName) {
		this.userName = userName;
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
	
	// Methods needed by spring security
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
	// We don't have these attributes
	public String getUsername() {return this.getEmail();}
	public boolean isAccountNonExpired() {return true;}
	public boolean isAccountNonLocked() {return true;}
	public boolean isCredentialsNonExpired() {return true;}
	public boolean isEnabled() {return true;}
    public Collection<? extends    GrantedAuthority> getAuthorities() {
        GrantedAuthority auth = new SimpleGrantedAuthority(user_role);
        List<GrantedAuthority> colAuth = new ArrayList<GrantedAuthority>();
        colAuth.add(auth);
        return colAuth;
    }
    
	public Set<Advert> getBookmarks() {
		return bookmarks;
	}
	public void setBookmarks(Set<Advert> bookmarks) {
		this.bookmarks = bookmarks;
	} 

	
}
