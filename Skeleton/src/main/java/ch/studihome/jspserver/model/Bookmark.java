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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bookmark other = (Bookmark) obj;
		if (advert == null) {
			if (other.advert != null)
				return false;
		} else if (!advert.equals(other.advert))
			return false;
		if (bmId == null) {
			if (other.bmId != null)
				return false;
		} else if (!bmId.equals(other.bmId))
			return false;
		if (interested != other.interested)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
}
