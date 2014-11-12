package ch.studihome.jspserver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Image name and information.
 * The images themselves are not saved in the database, but in the file system. 
 * Here is the information necessary to display the in the correct order 
 * 
 * @author TeamSix
 *
 */

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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((imgDescription == null) ? 0 : imgDescription.hashCode());
		result = prime * result + ((imgName == null) ? 0 : imgName.hashCode());
		result = prime * result + imgNum;
		result = prime * result + ((rimg_id == null) ? 0 : rimg_id.hashCode());
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
		RoomImg other = (RoomImg) obj;
		if (imgDescription == null)
		{
			if (other.imgDescription != null)
				return false;
		} else if (!imgDescription.equals(other.imgDescription))
			return false;
		if (imgName == null)
		{
			if (other.imgName != null)
				return false;
		} else if (!imgName.equals(other.imgName))
			return false;
		if (imgNum != other.imgNum)
			return false;
		if (rimg_id == null)
		{
			if (other.rimg_id != null)
				return false;
		} else if (!rimg_id.equals(other.rimg_id))
			return false;
		return true;
	}
	
	
}