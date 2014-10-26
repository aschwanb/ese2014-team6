package org.sample.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Advert {

    @Id
    @GeneratedValue
    private Long id;
    
    //private Long idUser;
    private String EmailUser;
    private String title;
    private String price;
    private String description;
    
    @OneToOne(cascade = {CascadeType.ALL})
    private Address address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdUser() {
		return EmailUser;
	}

	public void setIdUser(String EmailUser) {
		this.EmailUser = EmailUser;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	} 
    
	
}
