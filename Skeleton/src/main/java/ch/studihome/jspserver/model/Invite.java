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

/**
 * Invite class.
 * If an event is confirmed, it is 
 * used to generate an event object
 * 
 * @author TeamSix
 *
 */
@Entity
public class Invite extends Message {

	private String invDate;
	private String invTime;
	private Boolean reacted;
	
	@ManyToOne
	@JoinColumn(name="advert", nullable=true)
	private Advert advert;
//	Accept and Reject are handled through the Invitation Controller
	
	public Invite() {}
	public Invite(User fromUser, User toUser, String title, String message, String invDate, String invTime, Advert advert) {
		super(fromUser, toUser, title, message);
		this.setInvDate(invDate);
		this.setInvTime(invTime);
		this.advert=advert;
		this.reacted = false;
	}
	
	// Generate Link to related advertisement
	public String getLink() {
		return "advert?id="+this.advert.getadvId().toString();
	}
	
	public Advert getAdvert() {
		return this.advert;
	}
	
	public void setAdvert(Advert advert) {
		this.advert=advert;
	}
	
	public String getInvDate() {
		return invDate;
	}
	public void setInvDate(String invDate) {
		this.invDate = invDate;
	}
	public String getInvTime() {
		return invTime;
	}
	public void setInvTime(String invTime) {
		this.invTime = invTime;
	}
	public Boolean getReacted() {
		return reacted;
	}
	public void setReacted(Boolean reacted) {
		this.reacted = reacted;
	}
	public Boolean getInvite(){
		return true;
	}
}
