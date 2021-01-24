package utilities;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

public class Restassuredextentions {
	
	public static RequestSpecification request;
	
	public Restassuredextentions()
	
	{
		
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri("http://localhost:3000");
		builder.setContentType(ContentType.JSON);
		var requestspec = builder.build();
		request = RestAssured.given().spec(requestspec);
		
	}
	
	public static ResponseOptions<Response> getops(String url)
	{
		
		try {
			return request.get(new URI(url));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
		
	
	
    public static ResponseOptions<Response> PUTOps(String url, Map<String,String> body) {
        
        request.body(body);
        return request.put(url);
    }
    
    
    public static ResponseOptions<Response> POSTops(String url, Map<String,String> body) {
        
        request.body(body);
        return request.post(url);
    }
}
