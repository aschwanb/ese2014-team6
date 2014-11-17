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
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class Message {

    @Id
    @GeneratedValue
    private Long id;
    
    private Long fromId;
    private Long toId;
    private Date date;
    private String message;
    private Boolean unread;
    private Boolean responded;
	
    Message(Long from_id, Long to_id, String message) {
    	this.fromId = from_id;
    	this.toId = to_id;
    	this.message = message;
    	this.unread = true;
    	this.responded = false;
    }
    
    public Long getFrom_id() {
		return fromId;
	}
	public void setFrom_id(Long from_id) {
		this.fromId = from_id;
	}
	public Long getTo_id() {
		return toId;
	}
	public void setTo_id(Long to_id) {
		this.toId = to_id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getUnread() {
		return unread;
	}
	public void setUnread(Boolean unread) {
		this.unread = unread;
	}
	public Boolean getResponded() {
		return responded;
	}
	public void setResponded(Boolean responded) {
		this.responded = responded;
	}
    	
}
