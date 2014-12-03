package ch.studihome.jspserver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	private String title;
	private String link;
	private String linkTarget;
	private String color;
	private String content;
	
	
	public Event() {}
	/**
	 * Example:
	 *         Event event1 = new Event("2/12/2014", "SPORT and WELLNESS", "http://bic.cat", 
        		"<img src=\"http://gettingcontacts.com/upload/jornadas/sport-wellness_portada.png\" ><br>06-11-2013 - 09:00 <br> Tecnocampus Mataró Auditori");
	 */
	public Event(String date, String title, String link, String content, Advert advert) {
		this.date = date;
		this.title = title;
		this.link = link;
		this.content = content;
		this.linkTarget = "_blank";
		this.advert = advert;
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
				this.date, this.title, this.link, this.linkTarget, this.color, this.content);
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}
