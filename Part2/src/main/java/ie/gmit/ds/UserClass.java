package ie.gmit.ds;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
 
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class UserClass {
	@NotNull
	private int userID;
	@NotBlank @Length(min=2, max=40)
	private String userName;
	@NotBlank @Length(min=2, max=40)
	private String password;
	@Pattern(regexp=".+@.+\\.[a-z]+")
	private String email;
	
	public UserClass() {
		
	}
	
	public UserClass(int userID, String userName, String password, String email) {
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty
	public int getUserID() {
		return userID;
	}
	
	@JsonProperty
	public String getUserName() {
		return userName;
	}
	
	@JsonProperty
	public String getPassword() {
		return password;
	}
	
	@JsonProperty
	public String getEmail() {
		return email;
	}
	
}
