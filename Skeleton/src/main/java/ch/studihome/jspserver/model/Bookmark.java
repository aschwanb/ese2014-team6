package ch.studihome.jspserver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Id;


@Entity
public class Bookmark {
	
	@Id
	@GeneratedValue
	Long bmId;
	
	@ManyToOne @JoinColumn(name="usrId", nullable=false)
	private User user;
	
	@ManyToOne @JoinColumn(name="advId", nullable=false)
	private Advert advert;
	
	private boolean interested;
	
	public Bookmark() {}
	public Bookmark(User user, Advert advert, boolean show) {
		this.user = user;
		this.advert = advert;
		this.interested = show;
	}
	
	public Long getBmId() {
		return bmId;
	}
	public void setBmId(Long bmId) {
		this.bmId = bmId;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Advert getAdvert() {
		return advert;
	}
	public void setAdvert(Advert advert) {
		this.advert = advert;
	}
	public boolean getInterested() {
		return interested;
	}
	public void setInterested(boolean show) {
		this.interested = show;
	}
	
}
