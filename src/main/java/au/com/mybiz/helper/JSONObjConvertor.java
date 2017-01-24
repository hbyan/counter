package au.com.mybiz.helper;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import au.com.mybiz.model.SearchResponse;

public class JSONObjConvertor {
	

	public static String convertJavaObjToJSON(SearchResponse searchResponse){
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonString = mapper.writeValueAsString(searchResponse);
			return jsonString;
		} catch (IOException e) {
		
		}
		return "";
		
	}

}
