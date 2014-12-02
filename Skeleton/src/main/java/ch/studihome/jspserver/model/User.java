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
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Object representing a user of our web service
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
    private Long usrId;

    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String userRole;
    private String enabled;
    
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="user")
    private Set<Advert> ads = new HashSet<Advert>(0);
    
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="fromUser")
    private Set<Message> fromMsgs = new HashSet<Message>(0);

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="toUser")
    private Set<Message> toMsgs = new HashSet<Message>(0);

//	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="fromUser")
//    private Set<Invite> fromInvite= new HashSet<Invite>(0);
//
//	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="toUser")
//    private Set<Invite> toInvite = new HashSet<Invite>(0);
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)	//TODO LAZY vs EAGER problem
	@JoinTable(name = "bookmarklist",
			   joinColumns = { @JoinColumn(name = "usrId", nullable = false, updatable = false) }, 
			   inverseJoinColumns = { @JoinColumn(name = "advId", nullable = false, updatable = false) })
	private Set<Advert> bookmarks = new HashSet<Advert>(0);
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="interestees")	//TODO LAZY vs EAGER problem
	private Set<Advert> interests = new HashSet<Advert>(0);
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="user")
	private Calendar calendar;
	
	public User(){}
	public User(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = email;
		this.password = password;
		this.userRole = "ROLE_USER";
		this.enabled = "true";
	}
	
	
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

//	public Set<Invite> getFromInvite() {
//		return fromInvite;
//	}
//	public void setFromInvite(Set<Invite> fromInvite) {
//		this.fromInvite = fromInvite;
//	}
//	public Set<Invite> getToInvite() {
//		return toInvite;
//	}
//	public void setToInvite(Set<Invite> toInvite) {
//		this.toInvite = toInvite;
//	}
	
	public String toString() {
    	String out = "FirstName: " + firstName + "\n"+
    			"LastName: " + lastName + "\n"+
    			"UserName: " + userName + "\n"+
    			"Email: " + email + "\n"+
    			"Password: " + password + "\n"+
    			"UserRole: " + userRole + "\n"+
    			"Enabled: " + enabled + "\n" +
    			"GrantedAuthority: " + this.getAuthorities().iterator().next().toString();
    	return out;
    }
	
	public Calendar getCalendar() {
		return this.calendar;
	}
	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
    public Long getusrId() {
        return usrId;
    }

    public void setusrId(Long id) {
        this.usrId = id;
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
		return userRole;
	}

	public void setUser_role(String user_role) {
		this.userRole = user_role;
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
				+ ((userRole == null) ? 0 : userRole.hashCode());
		result = prime * result + ((usrId == null) ? 0 : usrId.hashCode());
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
		if (userRole == null)
		{
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		if (usrId == null)
		{
			if (other.usrId != null)
				return false;
		} else if (!usrId.equals(other.usrId))
			return false;
		return true;
	}
	// We don't have these attributes
	public String getUsername() {return userName;}
	public boolean isAccountNonExpired() {return true;}
	public boolean isAccountNonLocked() {return true;}
	public boolean isCredentialsNonExpired() {return true;}
	public boolean isEnabled() {return true;}
    public Collection<? extends    GrantedAuthority> getAuthorities() {
        GrantedAuthority auth = new SimpleGrantedAuthority(userRole);
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
	public Set<Advert> getInterests() {
		return interests;
	}
	public void setInterests(Set<Advert> interests) {
		this.interests = interests;
	} 

	
}
