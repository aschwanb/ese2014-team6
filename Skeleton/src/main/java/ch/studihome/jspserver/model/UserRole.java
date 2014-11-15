package ch.studihome.jspserver.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class UserRole {
	@Id
	@GeneratedValue
	private Long id;
	private String role;
	
	@ManyToMany
	private Set<User> user = new HashSet<User>();
	
	public UserRole(String role) {
		this.setRole(role);
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
