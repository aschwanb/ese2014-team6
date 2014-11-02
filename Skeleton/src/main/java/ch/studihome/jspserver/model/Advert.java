package ch.studihome.jspserver.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class Advert {
	@Id
	@GeneratedValue
	private Long adv_id;
	
	private String title;
	private int price;
	private boolean isWG;
	private int appartementSize;	//in square meters
	private int numberOfRooms;
	private int roomSize;	//in square meters, only for WG
	private int numberOfInhabitants;	//only for WG
	
	
	@Column(columnDefinition="character varying (2048) not null")
	private String description;
	
	@ManyToOne @JoinColumn(name="usr_id", nullable=false)
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy="advert")
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="advert")
	private Set<RoomImg> imgs = new HashSet<RoomImg>(0);
	
	
	public Long getId() {
		return adv_id;
	}
	
	public void setId(Long id) {
		this.adv_id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<RoomImg> getImgs() {
		return imgs;
	}

	public void setImgs(Set<RoomImg> imgs) {
		this.imgs = imgs;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isWG() {
		return isWG;
	}

	public void setWG(boolean isWG) {
		this.isWG = isWG;
	}

	public int getAppartementSize() {
		return appartementSize;
	}

	public void setAppartementSize(int appartementSize) {
		this.appartementSize = appartementSize;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public int getRoomSize() {
		return roomSize;
	}

	public void setRoomSize(int roomSize) {
		this.roomSize = roomSize;
	}

	public int getNumberOfInhabitants() {
		return numberOfInhabitants;
	}

	public void setNumberOfInhabitants(int numberOfInhabitants) {
		this.numberOfInhabitants = numberOfInhabitants;
	}
	
}
