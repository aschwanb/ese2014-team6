package ch.studihome.jspserver.model.pojos;

import javax.validation.constraints.NotNull;

public class InvitationForm extends MessageForm {
	
	@NotNull
	private String invDate;
	
	@NotNull
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
