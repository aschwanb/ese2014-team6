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
public class Invite extends Message {

	private String invDate;
	private String invTime;
	private Boolean accept; // In context with this.hasRead
	private Boolean reject; // In context with this.hasRead
	
	public Invite() {}
	public Invite(User fromUser, User toUser, String title, String message, String invDate, String invTime) {
		super(fromUser, toUser, title, message);
		this.setInvDate(invDate);
		this.setInvTime(invTime);
		this.setAccept(false);
		this.setReject(false);
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
	public Boolean getAccept() {
		return accept;
	}
	public void setAccept(Boolean accept) {
		this.accept = accept;
		this.reject = !accept;
	}
	public Boolean getReject() {
		return reject;
	}
	public void setReject(Boolean reject) {
		this.reject = reject;
		this.accept = !reject;
	}
}
