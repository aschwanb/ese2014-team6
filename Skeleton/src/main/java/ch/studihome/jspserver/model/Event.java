package ch.studihome.jspserver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Value;

/**
 * 
 * Events are displayed in a calendar
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
//				this.getDate(), this.getTitle(), this.getLink(), this.getLinkTarget(), this.getColor(), this.getAdvert().getTitle());
				this.getDate(), this.getAdvert().getTitle(), this.getLink(), this.getLinkTarget(), this.getColor(),
					"<img src=\"usrimg/" + this.getAdvert().getFirstImage() + "\" height=\"200\" width=\"200\">");
		return out;
	}
	
	/**
	 * Example:
	 *         Event event1 = new Event("2/12/2014", "SPORT and WELLNESS", "http://bic.cat", 
        		"<img src=\"http://gettingcontacts.com/upload/jornadas/sport-wellness_portada.png\" ><br>06-11-2013 - 09:00 <br> Tecnocampus Mataró Auditori");
	 */
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

}
