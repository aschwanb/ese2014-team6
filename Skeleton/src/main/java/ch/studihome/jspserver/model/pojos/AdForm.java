package ch.studihome.jspserver.model.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AdForm {

    private long id;
    
    @NotNull
    @Size(min = 8, message = "Title too short")
    private String title;
    
    @NotNull(message = "Must enter a street")
    private String street;
    
    @NotNull
    @Pattern(regexp = "[1-9][0-9][0-9][0-9]", 
    message = "Must be valid Plz. number")
    private String plz;
    
    @NotNull(message = "Must enter a city name")
    private String city;
    
    @NotNull
    private String latlng;
    
    @NotNull
    @Pattern(regexp = "[1-9][0-9]*", 
    message = "Must be valid number")
    private String price;
    
    @NotNull
    @Size(min = 12, message = "Description too short")
    private String description;

    private String ownerId;
    
    @NotNull
    private boolean isWG;
    
    @NotNull
	private int appartementSize;	//in square meters
    
    @NotNull
	private int numberOfRooms;
    
	private int roomSize;	//in square meters, only for WG
    
	private int numberOfInhabitants;	//only for WG
    
    private List<ImgObj> imgs = new ArrayList<ImgObj>();
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public List<ImgObj> getImgs() {
		return imgs;
	}

	public void setImgs(List<ImgObj> imgs) {
		this.imgs = imgs;
	}

	public String getLatlng() {
		return latlng;
	}

	public void setLatlng(String latlng) {
		this.latlng = latlng;
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
    
    public int getImgsCount(){
    	return imgs.size();
    }
}
