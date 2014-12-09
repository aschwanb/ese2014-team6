package ch.studihome.jspserver.model.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Extended from message form.
 * Adds some attributes to get
 * and validate all information
 * necessary to create invitation objects.
 * 
 * @author TeamSix
 *
 */
public class InvitationForm extends MessageForm {

	@NotNull @Size(min=2, message="Please enter a date.")
	private String invDate;
	@NotNull 
	@Size(min=2, message="Please enter a time.")
	private String invTime;
	@NotNull private Long usrId;
	@NotNull private Long adId;
	
	public Long getUsrId() {
		return this.usrId;
	}
	public void setUsrId(Long usrId) {
		this.usrId = usrId;
	}
	
	public Long getAdId() {
		return this.adId;
	}
	public void setAdId( Long adId) {
		this.adId = adId;
	}
	
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
