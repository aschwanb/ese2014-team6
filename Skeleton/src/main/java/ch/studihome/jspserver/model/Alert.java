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


@Entity
public class Alert
{
	@Id
	@GeneratedValue
	private Long alertId;
	
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

	public User getUser() {
		return user;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adverts == null) ? 0 : adverts.hashCode());
		result = prime * result + ((alertId == null) ? 0 : alertId.hashCode());
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + maxappartmentsize;
		result = prime * result + maxnumberofinhabitants;
		result = prime * result + maxprice;
		result = prime * result + maxroomsize;
		result = prime * result + minappartmentsize;
		result = prime * result + minnumberofinhabitants;
		result = prime * result + minprice;
		result = prime * result + minroomsize;
		result = prime * result + (int) (timeAndDate ^ (timeAndDate >>> 32));
		result = prime
				* result
				+ ((typeofappartment == null) ? 0 : typeofappartment.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Alert other = (Alert) obj;
		if (adverts == null) {
			if (other.adverts != null)
				return false;
		} else if (!adverts.equals(other.adverts))
			return false;
		if (alertId == null) {
			if (other.alertId != null)
				return false;
		} else if (!alertId.equals(other.alertId))
			return false;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (maxappartmentsize != other.maxappartmentsize)
			return false;
		if (maxnumberofinhabitants != other.maxnumberofinhabitants)
			return false;
		if (maxprice != other.maxprice)
			return false;
		if (maxroomsize != other.maxroomsize)
			return false;
		if (minappartmentsize != other.minappartmentsize)
			return false;
		if (minnumberofinhabitants != other.minnumberofinhabitants)
			return false;
		if (minprice != other.minprice)
			return false;
		if (minroomsize != other.minroomsize)
			return false;
		if (timeAndDate != other.timeAndDate)
			return false;
		if (typeofappartment == null) {
			if (other.typeofappartment != null)
				return false;
		} else if (!typeofappartment.equals(other.typeofappartment))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
}
