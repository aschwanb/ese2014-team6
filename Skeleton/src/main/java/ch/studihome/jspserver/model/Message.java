package ch.studihome.jspserver.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;
    	
	@ManyToOne
    @JoinColumn(name="fromUser", nullable=false)
    private User fromUser;

	@ManyToOne
    @JoinColumn(name="toUser", nullable=false)
    private User toUser;
    
    private Date date;
    private String title;
	private String message;
    private Boolean hasRead;
    private Boolean hasResponded;
	
    public Message() {}
    
    public Message(User fromUser, User toUser, String title, String message) {
    	this.fromUser = fromUser;
    	this.toUser = toUser;
    	this.title = title;
    	this.message = message;
    	this.hasRead = false;
    	this.hasResponded = false;
    	this.date = new Date();
    }
    
    public String toString() {
    	String out = "ID: " + this.id + "\n" +
    				 "From User: " + this.getFromUser().getEmail() + "\n" +
    				 "To User: " + this.getToUser().getEmail() + "\n" +
    				 "Message is unread: " + this.getHasRead().toString() + "\n" +
    				 "From User: " + this.getHasResponded().toString() + "\n" +
    				 "Title: " + this.getTitle() + "\n" +
    				 "Message: " + this.getMessage();
    	return out;
    }
  
    public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}
	
    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getHasRead() {
		return hasRead;
	}
	public void setHasRead(Boolean hasRead) {
		this.hasRead = hasRead;
	}
	public Boolean getHasResponded() {
		return hasResponded;
	}
	public void setHasResponded(Boolean hasResponded) {
		this.hasResponded = hasResponded;
	}
	public Boolean getInvite(){
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((fromUser == null) ? 0 : fromUser.hashCode());
		result = prime * result + ((hasRead == null) ? 0 : hasRead.hashCode());
		result = prime * result
				+ ((hasResponded == null) ? 0 : hasResponded.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((toUser == null) ? 0 : toUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (fromUser == null) {
			if (other.fromUser != null)
				return false;
		} else if (!fromUser.equals(other.fromUser))
			return false;
		if (hasRead == null) {
			if (other.hasRead != null)
				return false;
		} else if (!hasRead.equals(other.hasRead))
			return false;
		if (hasResponded == null) {
			if (other.hasResponded != null)
				return false;
		} else if (!hasResponded.equals(other.hasResponded))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (toUser == null) {
			if (other.toUser != null)
				return false;
		} else if (!toUser.equals(other.toUser))
			return false;
		return true;
	}
    	
}
