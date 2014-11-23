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
    	
}
