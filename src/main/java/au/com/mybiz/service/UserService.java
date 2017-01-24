package au.com.mybiz.service;

import au.com.mybiz.exceptions.UserNotExistsException;
import au.com.mybiz.model.User;


public interface UserService {
	
	 public User find (String userName) throws UserNotExistsException; 
}
