package ch.studihome.jspserver.model.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
/**
 * Used to get the data from a Message Form
 * 
 * @author TeamSiX
 */
public class MessageForm {

    private Long id;
    @NotNull
    private String fromUserEmail;
    @NotNull
    private String toUserEmail;
    @NotNull
    @Size(min = 1, message = "Your message has no title")
    private String title;
    @NotNull
    @Size(min = 3, message = "Plese enter your message")
    private String message;
    
    public String toString(){
    	String out = "ID: " + id + "\n" +
    				 "To User: " + toUserEmail + "\n" +
    				 "From User: " + fromUserEmail + "\n" +
    				 "Title: " + title + "\n" +
    				 "Message: " + message;
    	return out;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFromUserEmail() {
		return fromUserEmail;
	}
	public void setFromUserEmail(String fromUser) {
		this.fromUserEmail = fromUser;
	}
	public String getToUserEmail() {
		return toUserEmail;
	}
	public void setToUserEmail(String toUser) {
		this.toUserEmail = toUser;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    
}
