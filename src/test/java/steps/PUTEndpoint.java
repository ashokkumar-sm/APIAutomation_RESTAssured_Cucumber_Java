package steps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utilities.Restassuredextentions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/feature", 
glue= {"steps"},
plugin = {"json:target/cucumber.json"})

public class PUTEndpoint {
	
	  @Given("^PUT operation for \"([^\"]*)\"$")
	  public void iPerformPUTOperationFor(String url, DataTable table) throws Throwable {
	    
		 // List<Map<String,String>> data = table.asMaps(String.class,String.class);
		  List<List<String>> data = table.cells();

	      Map<String, String> body = new HashMap<>();
	     // body.put("id", data.get(1).get(0));
	      body.put("first_name", data.get(1).get(1));
	      body.put("last_name", data.get(1).get(2));

	      //Perform post operation
	      Restassuredextentions.PUTOps(url, body);
	  }

}
