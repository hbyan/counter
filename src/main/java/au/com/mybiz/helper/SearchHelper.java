package au.com.mybiz.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import au.com.mybiz.model.SearchRequest;
import au.com.mybiz.model.SearchResponse;

@Component
public class SearchHelper {
	
	public  SearchResponse doSearch(SearchRequest searchRequest) {
		SearchResponse response = new SearchResponse();
		
		List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>();
		Map<String, Integer> countList = new HashMap<String, Integer>();
		if(searchRequest == null || searchRequest.getSearchText() == null){
			return response;
		}
		for(String searchText : searchRequest.getSearchText()){
			countList.put(searchText, findCountByName(searchText));
		}
		list.add(countList);
		response.setCountsMap(list);
		return response;
	}
	
	private Map<String, Integer> mockSearchData(){
		Map<String, Integer> countResultList = new HashMap<String, Integer>();
		countResultList.put("Duis", 11);
		countResultList.put("Sed", 16);
		countResultList.put("Donec", 8);
		countResultList.put("Augue", 7);
		countResultList.put("Pellentesque", 6);
		countResultList.put("123", 0);
		return countResultList;
	}
	
	private Integer findCountByName(String searchText){
		Map<String, Integer> countResultList = mockSearchData();
		Integer countVal = countResultList.get(searchText);
		return countVal;
	}

}
