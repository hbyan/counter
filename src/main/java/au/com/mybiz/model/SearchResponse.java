package au.com.mybiz.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResponse  implements Serializable{
	
	private static final long serialVersionUID = -2925209065864451739L;
	@JsonProperty("counts")
    private List<Map<String, Integer>> countsMap = new ArrayList<Map<String, Integer>>();

	public List<Map<String, Integer>> getCountsMap() {
		return countsMap;
	}

	public void setCountsMap(List<Map<String, Integer>> countsMap) {
		this.countsMap = countsMap;
	}

	
}
