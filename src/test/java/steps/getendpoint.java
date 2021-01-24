package steps;

import org.json.simple.JSONObject;
import org.junit.runner.RunWith;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.Restassuredextentions;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.hasItem;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/feature", 
glue= {"steps"},
plugin = {"json:target/cucumber.json"})


public class getendpoint {
	
	private static ResponseOptions<Response> response;
	
  @Given("Call GET Endpoint for \"([^\"]*)\"$")
  public void call_get_endpoint_for_users(String url) throws Throwable {
	  
	  response = Restassuredextentions.getops(url);
	  
  }


  @And("^I should see first name \"([^\"]*)\"$")
  public void i_should_see_first_name(String firstname)throws Throwable {
	  
	 assertThat(response.getBody().jsonPath().get("first_name"),hasItem("Ashok"));
  }
  
  
  }


