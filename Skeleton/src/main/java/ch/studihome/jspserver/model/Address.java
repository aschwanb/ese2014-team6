package ch.studihome.jspserver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Basic Address object
 * Used in advertisements
 * 
 * @author TeamSix
 *
 */


@Entity
public class Address {
	@Id
	@GeneratedValue
	private Long adrId;
	
	private String street;
	private String plz;
	private String city;
	private String coordinate;
	
	@OneToOne
	private Advert advert;
	
	public Address() {}
	public Address(String street, String plz, String city, String coordinate, Advert advert) {
		this.street = street;
		this.plz = plz;
		this.city = city;
		this.coordinate = coordinate;
		this.advert = advert;
	}
	
	public Long getAdr_id() {
		return adrId;
	}
	
	public void setAdr_id(Long id) {
		this.adrId = id;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getPlz() {
		return plz;
	}
	
	public void setPlz(String plz) {
		this.plz = plz;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public Advert getAdvert() {
		return advert;
	}

	public void setAdvert(Advert advert) {
		this.advert = advert;
	}

	public String getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (adrId == null)
		{
			if (other.adrId != null)
				return false;
		} else if (!adrId.equals(other.adrId))
			return false;
		if (city == null)
		{
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (coordinate == null)
		{
			if (other.coordinate != null)
				return false;
		} else if (!coordinate.equals(other.coordinate))
			return false;
		if (plz == null)
		{
			if (other.plz != null)
				return false;
		} else if (!plz.equals(other.plz))
			return false;
		if (street == null)
		{
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
	
	
}
