package au.com.mybiz.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchRequest implements Serializable{

	private static final long serialVersionUID = -8968351971507788517L;
	@JsonProperty("searchText")
	private List<String> searchText;

	public List<String> getSearchText() {
		return searchText;
	}

	public void setSearchText(List<String> searchText) {
		this.searchText = searchText;
	}

}
