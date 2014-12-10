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
	private Long rimgId;
	
	private int imgNum;
	private String imgName;
	private String imgDescription;
	
	@ManyToOne @JoinColumn(name="advId", nullable=false)
	Advert advert;
	
	public Long getRimg_id() {
		return rimgId;
	}
	
	public void setRimg_id(Long id) {
		this.rimgId = id;
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
		if (rimgId == null)
		{
			if (other.rimgId != null)
				return false;
		} else if (!rimgId.equals(other.rimgId))
			return false;
		return true;
	}
	
	
}