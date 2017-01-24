package au.com.mybiz.service;

import org.springframework.stereotype.Service;

import au.com.mybiz.exceptions.UserNotExistsException;
import au.com.mybiz.model.User;

@Service("userService") 
public class UserServiceImpl implements UserService{

	/**
	 * Look up the data source for allowed user authentication
	 */
	@Override
	public User find(String userName) throws UserNotExistsException { 
        return new User("optus","candidates");  
	}

}
