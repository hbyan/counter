package au.com.mybiz.utils;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import au.com.mybiz.model.SearchResponse;

public class JsonObjectUtilsTest {

	
	@Test
	public void testConvertJavaObjToJson() {
		
		String jsonString = "{\"counts\":[{\"Sed\":16,\"Donec\":8,\"Duis\":11}]}";
		
		SearchResponse response = new SearchResponse();
		List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>();
		Map<String, Integer> countList = new HashMap<String, Integer>();
		countList.put("Duis", 11);
		countList.put("Sed", 16);
		countList.put("Donec", 8);
		list.add(countList);
		response.setCountsMap(list);
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonInString = mapper.writeValueAsString(response);
			assertEquals(jsonString, jsonInString);
		} catch (IOException e) {
		
		}

	}

}
