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
	public Event(String date, String title, String link, Advert advert) {
		this.date = date;
		this.title = title;
		this.link = link;
		this.linkTarget = "_blank";
		this.advert = advert;
		this.content = this.advert.getTitle();
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((advert == null) ? 0 : advert.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result
				+ ((linkTarget == null) ? 0 : linkTarget.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
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
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (linkTarget == null) {
			if (other.linkTarget != null)
				return false;
		} else if (!linkTarget.equals(other.linkTarget))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	
}
