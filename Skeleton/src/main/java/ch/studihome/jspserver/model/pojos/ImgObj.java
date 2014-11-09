package ch.studihome.jspserver.model.pojos;

import org.springframework.web.multipart.MultipartFile;

public class ImgObj{
	private String description;
	private MultipartFile file;
	private String state;
	private String number;
	
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
	
}