package ch.studihome.jspserver.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Generic advert object. Can be for shared flats or apartments.
 *  
 * @author TeamSix
 *
 */
@Entity
public class Advert {
	
	@Id
	@GeneratedValue
	private Long advId;
	
	private String title;
	private int price;
	private boolean isWG;
	private int appartementSize;	//in square meters
	private int numberOfRooms;
	private int roomSize;	//in square meters, only for WG
	private int numberOfInhabitants;	//only for WG
	
	@Column(columnDefinition="character varying (2048) not null")
	private String description;
	
	@ManyToOne @JoinColumn(name="usrId", nullable=false)
	private User user;
	
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="advert")
    private Set<Event> events = new HashSet<Event>(0);

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="advert")
    private Set<Invite> invites = new HashSet<Invite>(0);
    
	@OneToOne(cascade = CascadeType.ALL, mappedBy="advert")
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="advert")
	private Set<RoomImg> imgs = new HashSet<RoomImg>(0);
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="advert")	//TODO LAZY vs EAGER problem
	private Set<Bookmark> bookmarks = new HashSet<Bookmark>(0);
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="adverts")	//TODO LAZY vs EAGER problem
	private Set<Alert> alerts = new HashSet<Alert>(0);
	
	private long timeAndDate;

	public Advert() {}
	// TODO: Add images in constructor
	public Advert(
			String title, int price, boolean isWG, int appartementSize, int numberOfRooms, 
			int roomSize, int numberOfInhabitants, String description, User user, Address address
			) {
		this.title = title;
		this.price = price;
		this.isWG = isWG;
		this.numberOfRooms = numberOfRooms;
		this.roomSize = roomSize;
		this.numberOfInhabitants = numberOfInhabitants;
		this.description = description;
		this.user = user;
		this.address = address;
	}
	
	/**
	 * To get the first image from jsp-file
	 * 
	 * @return name of the first image
	 */
	public String getFirstImage() {
		try {
			return this.getImgs().iterator().next().getImgName();			
		} catch (Exception e) {
			// TODO: handle exception
			return "Image not found";
		}

	}
	public Long getadvId() {
		return advId;
	}
	
	public void setadvId(Long id) {
		this.advId = id;
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
	
	public Set<Event> getEvents() {
		return this.events;
	}
	public void setEvents(Set<Event> events) {
		this.events = events;
	}

	public Set<Invite> getInvites() {
		return this.invites;
	}
	public void setInvites(Set<Invite> invites) {
		this.invites = invites;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean getIsWG() {
		return isWG;
	}

	public void setIsWG(boolean isWG) {
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

	public Set<Bookmark> getBookmarks() {
		return bookmarks;
	}
	public void setBookmarks(Set<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}
	public long getTimeAndDate() {
		return timeAndDate;
	}
	public void setTimeAndDate(long timeAndDate) {
		this.timeAndDate = timeAndDate;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((advId == null) ? 0 : advId.hashCode());
		result = prime * result + appartementSize;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + (isWG ? 1231 : 1237);
		result = prime * result + numberOfInhabitants;
		result = prime * result + numberOfRooms;
		result = prime * result + price;
		result = prime * result + roomSize;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
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
		Advert other = (Advert) obj;
		if (advId == null)
		{
			if (other.advId != null)
				return false;
		} else if (!advId.equals(other.advId))
			return false;
		if (appartementSize != other.appartementSize)
			return false;
		if (description == null)
		{
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (isWG != other.isWG)
			return false;
		if (numberOfInhabitants != other.numberOfInhabitants)
			return false;
		if (numberOfRooms != other.numberOfRooms)
			return false;
		if (price != other.price)
			return false;
		if (roomSize != other.roomSize)
			return false;
		if (title == null)
		{
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
}
