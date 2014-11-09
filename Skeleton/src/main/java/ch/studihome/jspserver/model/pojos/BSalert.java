package ch.studihome.jspserver.model.pojos;

public class BSalert
{
	public enum Type{
		success,
		info,
		warning,
		danger
	}
	
	private String type;
	private String message;
	
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
