package au.com.mybiz.model;

import java.io.Serializable;

/**
 * 
 * @author wzou
 *
 */
public class User implements Serializable{

	private static final long serialVersionUID = -2161335006230974554L;
	
	private String userName;
	private String password;
	
	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
