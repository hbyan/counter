package au.com.mybiz.client;

import static org.junit.Assert.*;

import org.junit.Test;

public class CounterClientIT {
	
	@Test
	public void testRetrieveSearchResults(){
		
		String jsonString = "{\"searchText\":[\"Duis\", \"Sed\", \"Donec\", \"Augue\", \"Pellentesque\", \"123\"]}";
		
		CountClient client = new CountClient("http://localhost:7777");
		String result = client.retriveSearchResults(jsonString);
		assertNotNull(result);
	}

	
	@Test
	public void testWordCounter(){
		
		CountClient client = new CountClient("http://localhost:7777");
		String result = client.wordCounter(5);
		assertNotNull(result);
	}

}
