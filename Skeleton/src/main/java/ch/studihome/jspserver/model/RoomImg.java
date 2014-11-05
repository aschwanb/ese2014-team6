package ch.studihome.jspserver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class RoomImg{
	@Id
	@GeneratedValue
	private Long rimg_id;
	
	private int imgNum;
	private String imgName;
	private String imgDescription;
	
	@ManyToOne @JoinColumn(name="adv_id", nullable=false)
	Advert advert;
	
	public Long getRimg_id() {
		return rimg_id;
	}
	
	public void setRimg_id(Long id) {
		this.rimg_id = id;
	}
	
	public String getImgName() {
		return imgName;
	}
	
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	
	public String getImgDescription() {
		return imgDescription;
	}
	
	public void setImgDescription(String imgDescription) {
		this.imgDescription = imgDescription;
	}
	
	public Advert getAdvert() {
		return advert;
	}
	
	public void setAdvert(Advert advert) {
		this.advert = advert;
	}

	public int getImgNum() {
		return imgNum;
	}

	public void setImgNum(int imgNum) {
		this.imgNum = imgNum;
	}
	
}