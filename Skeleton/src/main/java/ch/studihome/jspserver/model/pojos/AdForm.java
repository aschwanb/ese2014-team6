package ch.studihome.jspserver.model.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

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
    
    @NotNull(message = "Must enter a price")
    private String price;
    
    @NotNull
    @Size(min = 12, message = "Description too short")
    private String description;
    
    @NotNull(message = "Invalide file")
    private MultipartFile image;

    private String ownerEmail;
    
    
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

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
    
    
}
