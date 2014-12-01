package ch.studihome.jspserver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private int min_price;
	private int max_price;
	private int min_room_size;
	private int max_room_size;
	private int min_appartment_size;
	private int max_appartment_size;
	private int min_number_of_inhabitants;
	private int max_number_of_inhabitants;
	private String area;
	private String type_of_apartment;
	
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

	public int getMin_price() {
		return min_price;
	}

	public void setMin_price(int min_price) {
		this.min_price = min_price;
	}

	public int getMax_price() {
		return max_price;
	}

	public void setMax_price(int max_price) {
		this.max_price = max_price;
	}

	public int getMin_room_size() {
		return min_room_size;
	}

	public void setMin_room_size(int min_room_size) {
		this.min_room_size = min_room_size;
	}

	public int getMax_room_size() {
		return max_room_size;
	}

	public void setMax_room_size(int max_room_size) {
		this.max_room_size = max_room_size;
	}

	public int getMin_appartment_size() {
		return min_appartment_size;
	}

	public void setMin_appartment_size(int min_appartment_size) {
		this.min_appartment_size = min_appartment_size;
	}

	public int getMax_appartment_size() {
		return max_appartment_size;
	}

	public void setMax_appartment_size(int max_appartment_size) {
		this.max_appartment_size = max_appartment_size;
	}

	public int getMin_number_of_inhabitants() {
		return min_number_of_inhabitants;
	}

	public void setMin_number_of_inhabitants(int min_number_of_inhabitants) {
		this.min_number_of_inhabitants = min_number_of_inhabitants;
	}
	
	public int getMax_number_of_inhabitants() {
		return max_number_of_inhabitants;
	}

	public void setMax_number_of_inhabitants(int max_number_of_inhabitants) {
		this.max_number_of_inhabitants = max_number_of_inhabitants;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getType_of_apartment() {
		return type_of_apartment;
	}

	public void setType_of_apartment(String type_of_apartment) {
		this.type_of_apartment = type_of_apartment;
	}
	
	
}
