package au.com.mybiz.utils;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class CountLogger {
	
	private static final Logger LOGGER = Logger.getLogger("au.com.mybiz.count");
	
	public void info(final String message) {
		LOGGER.info(message);
	}
	
	public void error(final String errorMessage, final Throwable t) {
		LOGGER.error(errorMessage, t);
	}
	
	public void error(final String errorMessage) {
		LOGGER.error(errorMessage);
	}

}
