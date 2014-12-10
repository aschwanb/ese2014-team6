package ch.studihome.jspserver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Value;

/**
 * 
 * Event class used in calendar class,
 * where events are displayed.
 * 
 * @author teamsix
 *
 */
@Entity
public class Event {

	@Id
	@GeneratedValue
	private Long eventId;

	@ManyToOne
	@JoinColumn(name="advert", nullable=false)
	private Advert advert;
	
	private String date;
	private String time;
	private String linkTarget;
	private String color;

	
	public Event() {}
	public Event(Invite invite) {
		this.date = invite.getInvDate();
		this.time = invite.getInvTime();
		this.linkTarget = "_blank";
		this.advert = invite.getAdvert();
	}

	
	public String getLink() {
		return "advert?id="+this.advert.getadvId().toString();
	}
	public String toString(){
		String out = String.format(
				"{\n" +
				"date : \'%s\',\n" +
				"title : \'%s\',\n" +
				"link : \'%s\',\n" +
				"linkTarget : \'%s\',\n" +
				"color : \'%s\',\n" +
				"content : \'%s\',\n" +
				"class : \'\',\n" +
				"displayMonthController : \'true\',\n" +
				"displayYearController : \'true\',\n" +
				"nMonths : \'6',\n" +
				"},",
				this.getDate(), this.getAdvert().getTitle(), this.getLink(), this.getLinkTarget(), this.getColor(),
					"<img src=\"usrimg/" + this.getAdvert().getFirstImage() + "\" height=\"200\" width=\"200\">");
		return out;
	}
	
	public Advert getAdvert() {
		return this.advert;
	}
	public void setAdvert(Advert advert) {
		this.advert = advert;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLinkTarget() {
		return linkTarget;
	}
	public void setLinkTarget(String linkTarget) {
		this.linkTarget = linkTarget;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (advert == null) {
			if (other.advert != null)
				return false;
		} else if (!advert.equals(other.advert))
			return false;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (linkTarget == null) {
			if (other.linkTarget != null)
				return false;
		} else if (!linkTarget.equals(other.linkTarget))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
	
	

	
}
