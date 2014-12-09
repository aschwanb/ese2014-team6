package ch.studihome.jspserver.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * Stores a filter and a list of Adverts that fit the filter
 * 
 * @author TeamSix
 */
@Entity
public class Alert
{
	@Id
	@GeneratedValue
	private Long alertId;
	
	/**
	 * Owner of the alert
	 */
	@ManyToOne @JoinColumn(name="usrId", nullable=false)
	private User user;
	
	//Data
	private int minprice;
	private int maxprice;
	private int minroomsize;
	private int maxroomsize;
	private int minappartmentsize;
	private int maxappartmentsize;
	private int minnumberofinhabitants;
	private int maxnumberofinhabitants;
	private String area;
	private String typeofappartment;
	private long timeAndDate;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)	//TODO LAZY vs EAGER problem
	@JoinTable(name = "alertstlist",
			   joinColumns = { @JoinColumn(name = "alertId", nullable = false, updatable = false) }, 
			   inverseJoinColumns = { @JoinColumn(name = "advId", nullable = false, updatable = false) })
	private Set<Advert> adverts;
	
	public Long getAlertId(){
		return alertId;
	}

	public void setAlertId(Long alertId) {
		this.alertId = alertId;
	}

	/**
	 * @return owner of alert
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Set owner of alert
	 * @param user owner of alert
	 */
	public void setUser(User user) {
		this.user = user;
	}

	public int getMinprice() {
		return minprice;
	}

	public void setMinprice(int minprice) {
		this.minprice = minprice;
	}

	public int getMaxprice() {
		return maxprice;
	}

	public void setMaxprice(int maxprice) {
		this.maxprice = maxprice;
	}

	public int getMinroomsize() {
		return minroomsize;
	}

	public void setMinroomsize(int minroomsize) {
		this.minroomsize = minroomsize;
	}

	public int getMaxroomsize() {
		return maxroomsize;
	}

	public void setMaxroomsize(int maxroomsize) {
		this.maxroomsize = maxroomsize;
	}

	public int getMinappartmentsize() {
		return minappartmentsize;
	}

	public void setMinappartmentsize(int minappartmentsize) {
		this.minappartmentsize = minappartmentsize;
	}

	public int getMaxappartmentsize() {
		return maxappartmentsize;
	}

	public void setMaxappartmentsize(int maxappartmentsize) {
		this.maxappartmentsize = maxappartmentsize;
	}

	public int getMinnumberofinhabitants() {
		return minnumberofinhabitants;
	}

	public void setMinnumberofinhabitants(int minnumberofinhabitants) {
		this.minnumberofinhabitants = minnumberofinhabitants;
	}
	
	public int getMaxnumberofinhabitants() {
		return maxnumberofinhabitants;
	}

	public void setMaxnumberofinhabitants(int maxnumberofinhabitants) {
		this.maxnumberofinhabitants = maxnumberofinhabitants;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTypeofappartment() {
		return typeofappartment;
	}

	public void setTypeofappartment(String string) {
		this.typeofappartment = string;
	}

	public long getTimeAndDate() {
		return timeAndDate;
	}

	public void setTimeAndDate(long timeAndDate) {
		this.timeAndDate = timeAndDate;
	}

	public Set<Advert> getAdverts() {
		return adverts;
	}

	public void setAdverts(Set<Advert> adverts) {
		this.adverts = adverts;
	}
	
	
}
