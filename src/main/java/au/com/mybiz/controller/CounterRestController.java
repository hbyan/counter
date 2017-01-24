package au.com.mybiz.controller;

import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.core.header.AcceptableMediaType;

import au.com.mybiz.helper.JSONObjConvertor;
import au.com.mybiz.helper.SearchHelper;
import au.com.mybiz.helper.WordCounterHelper;
import au.com.mybiz.model.SearchRequest;
import au.com.mybiz.model.SearchResponse;

@RestController
public class CounterRestController {

	@Autowired
	private SearchHelper SearchHelper;
	
	@Value("${input.text.file.name}")
	private String textFileName;
	
	@RequestMapping(value = "/counter-api/search", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, method = { RequestMethod.POST })
	public String findCounts(@RequestBody SearchRequest searchRequest) {
		SearchResponse searchResponse = SearchHelper.doSearch(searchRequest);
		return JSONObjConvertor.convertJavaObjToJSON(searchResponse);
	}

	@RequestMapping(value = "/counter-api/top/{num}",  produces = { MediaType.TEXT_PLAIN_VALUE },  method = {RequestMethod.POST, RequestMethod.GET})
	public String processWordCounter(@PathVariable String num){
		String message = "";
		String resultInCSV = "";		
		int lineNum = 0;
		try{
			lineNum = Integer.parseInt(num);
			Map<String, Integer> orderedCountResult = WordCounterHelper.getOrderedWordCounter(textFileName);
			resultInCSV = getResultInCSV(orderedCountResult,lineNum);
		}catch(NumberFormatException e){
			message = String.format("Invalid input number", num);
		}catch(Exception e){
			message = String.format("Fail to retrieve the result due to {%s}", e.getMessage());
		}
		if(!resultInCSV.equals("")){
			return resultInCSV;
		}
		return message;
	}

	private String getResultInCSV(Map<String, Integer> orderedCountResult, int num) {
		StringBuffer result = new StringBuffer();
		int lineCount = 0;
		for (Map.Entry<String, Integer> entry : orderedCountResult.entrySet()) {
			if (num == lineCount)
				break;
			String row = entry.getKey() + "|" + entry.getValue();
			if (!result.equals("")) {
				result.append(System.getProperty("line.separator"));
			}
			result.append(row);
			lineCount++;
			;
		}
		return result.toString();
	}

}
