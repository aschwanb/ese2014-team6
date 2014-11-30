package ch.studihome.jspserver.model.pojos;

import javax.validation.constraints.NotNull;

public class InvitationForm extends MessageForm {
	
	@NotNull
	private String dateAndTime;
	
	public String getDateAndTime() {
		return this.dateAndTime;
	}
	
	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	
	public String toString() {
		return super.toString() + "\n" + dateAndTime;
	}
}
