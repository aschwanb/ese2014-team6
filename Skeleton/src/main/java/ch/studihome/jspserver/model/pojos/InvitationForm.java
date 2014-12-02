package ch.studihome.jspserver.model.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InvitationForm extends MessageForm {
	
	@NotNull
	@Size(min=2, message="Please enter a date.")
	private String invDate;
	
	@NotNull
	@Size(min=2, message="Please enter a time.")
	private String invTime;
	
	public String getInvTime() {
		return this.invTime;
	}
	
	public void setInvTime(String invTime) {
		this.invTime = invTime;
	}
	
	public String getInvDate() {
		return this.invDate;
	}
	public void setInvDate(String invDate) {
		this.invDate = invDate;
	}
	
	public String toString() {
		return super.toString() + "\n" +
				"Time: " + invTime + "\n" +
				"Date: " + invDate;
	}
}
