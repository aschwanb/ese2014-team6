package ch.studihome.jspserver.model.pojos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import ch.studihome.jspserver.model.User;

/**
 * Used to get the data from a Message Form
 * 
 * @author TeamSiX
 */
public class MessageForm {

    private Long id;
    @NotNull
    private User fromUser;
    @NotNull
    private User toUser;
    @NotNull @Size(min = 1, message = "Your message has no title")
    private String title;
    @NotNull @Size(min = 3, message = "Plese enter your message")
    private String message;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getFromUser() {
		return fromUser;
	}
	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}
	public User getToUser() {
		return toUser;
	}
	public void setToUser(User toUser) {
		this.toUser = toUser;
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
