package ie.gmit.ds;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserLogin {

	private int id;
	private String password;
	
	public UserLogin() {
		this.id = id;
		this.password = password;
	}
	
	@JsonProperty
	public int getID() {
		return id;
	}
	
	@JsonProperty
	public String getPassword() {
		return password;
	}
	
}
