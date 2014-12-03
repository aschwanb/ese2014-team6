package ch.studihome.jspserver.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinTable(name="EventToCal",
    		   joinColumns = { @JoinColumn(name = "id", nullable = false, updatable = false) },
    		   inverseJoinColumns = { @JoinColumn(name = "eventId", nullable = false, updatable = false) })
    private Set<Event> events = new HashSet<Event>(0);
	
	public Calendar() {
		this.name = "calendari_literal1";
	}
	public Calendar(User user) {
		this.user = user;
		this.name = "calendari_literal1";
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
	
	public Set<Event> getEvents() {
		return this.events;
	}
	
	public void setEvents(Set<Event> events) {
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
