package ch.studihome.jspserver.model.pojos;

/**
 * Used to feed BootStrap Alert data to the jsp
 * 
 * @author TeamSiX
 */
public class BSalert
{
	/**
	 *	type corresponding to the BootStrap alert styles
	 */
	public enum Type{
		success,
		info,
		warning,
		danger
	}
	
	private String type;
	private String message;
	
	/**
	 * @param type Type of alert
	 * @param message Displayed message
	 */
	public BSalert(Type type, String message)
	{
		this.message = message;
		
		switch(type)
		{
			case success:
				this.type = "success";
				break;
			case info:
				this.type = "info";
				break;
			case warning:
				this.type = "warning";
				break;
			case danger:
				this.type = "danger";
				break;
		}
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
