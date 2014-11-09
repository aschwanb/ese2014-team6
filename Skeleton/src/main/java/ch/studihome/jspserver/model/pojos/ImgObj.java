package ch.studihome.jspserver.model.pojos;

import org.springframework.web.multipart.MultipartFile;

public class ImgObj{
	private String description;
	private MultipartFile file;	// for image upload
	private String state;	// delete, new, change or nochange
	private String number;	// identifies the image, important for delete and change
	private String url;	// for image display
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}