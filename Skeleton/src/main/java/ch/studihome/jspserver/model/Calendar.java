package ch.studihome.jspserver.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Calendar {
	
	@Id
	@GeneratedValue
	private Long calId;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user")
	private User user;
	
	private String name;
	private ArrayList<Event> events;
	
	public Calendar() {
		this.name = "calendari_literal1";
	}
	public Calendar(User user) {
		this.user = user;
		this.name = "calendari_literal1";
	}
	public Calendar(ArrayList<Event> events) {
		this.name = "calendari_literal1";
		this.events = events;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Event> getEvents() {
		return events;
	}

	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}
	
	public void addEvent(Event event) {
		this.events.add(event);
	}
	public String getString() {
		return this.toString();
	}
	public String toString() {
		String out = "<div class=\"col-sm-4\">\n" +
					 "<script>" + 
					 "$(document).ready(function() {\n"+
					 "var monthNames = [ \"January\", \"February\", \"March\", \"April\", \"May\", \"June\", "+
					 "\"July\", \"August\", \"September\", \"October\", \"November\", \"December\" ];" +
					 "var dayNames = [ \"M\", \"T\", \"W\", \"T\", \"F\", \"S\", \"S\"];" +
					 "var events = [";
		if (events != null) {
			for (Event e : events) { out = out + e.toString(); }
		}
		out = out + "];\n" +
				String.format("$(\'#%s\').bic_calendar({\n" +
					"events : events,\n"+
					"enableSelect : false,\n"+
					"multiSelect : false,\n"+
					"dayNames : dayNames,\n"+
					"monthNames : monthNames,\n"+
					"showDays : true,\n"+
					"displayMonthController : true,\n"+
					"displayYearController : true,\n"+
					"reqAjax : {\n"+
					"type : \'get\',\n"+
					"url : \'http://bic.cat/bic_calendar/index.php\'\n"+
					"}\n"+
					"});\n"+
					"});\n"+
					"</script>\n"+
					"<div id=\"%s\"></div>\n"+
					"</div>\n",
					this.name, this.name);
				return out;
		
	}
	
	

}
