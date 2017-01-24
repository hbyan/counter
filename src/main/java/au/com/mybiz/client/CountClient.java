package au.com.mybiz.client;

import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class CountClient {

	private WebResource resource;

	public CountClient(final String baseURL) {
		
		ClientConfig cfg = new DefaultClientConfig();
	
		cfg.getClasses().add(JacksonJaxbJsonProvider.class);
		Client client = Client.create(cfg);
		resource = client.resource(baseURL);
	
	}

	public String retriveSearchResults(String request) {
		return this.resource.path("/counter-api/search").accept(MediaType.APPLICATION_JSON_TYPE)
				.type(MediaType.APPLICATION_XML).entity(request, MediaType.APPLICATION_JSON_TYPE)
				.get(String.class);
	}
	
	public String wordCounter(int num) {
		String path = "/counter-api/top/"+num;
		
		String result = "";
		try{
			result =this.resource.path(path)
					.accept("text/csv")
					.get(String.class);
		}catch(Exception e){
			System.out.println(e);
		}
		return result;
	}

}
