package stepDefinations;


import base.CrudOperation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class config extends CrudOperation {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    public static String configId;
    public static String AccessToken;
    JsonPath js;

   utilities.Utilities util ;

    public config() throws IOException {
    }

    @Given("User calls {string} with {string} http request")
    public void userCallsWithHttpRequest(String apiName, String requestType) throws IOException {

        if(requestType.equalsIgnoreCase("POST")) {
            response = performPOSTcall(apiName);
        }
        else if(requestType.equalsIgnoreCase("GET")) {
			response = performPOSTcall(apiName);
        }

    }

    @And("{string} in response body is {string}")
    public void inResponseBodyIs(String value1, String value2) {
        System.out.println("}}}}}}}}}}}}}}}}} resp"+ response.asString());
        String resp=response.asString();
        js = JsonPath.given(util.getJsonPath(js.get(resp)));
        Assert.assertEquals(js.get(value1), value2);
    }


    @Then("the API call got success with status code {int}")
    public void theAPICallGotSuccessWithStatusCode(int arg0) {
        System.out.println("response"+ response.asString());
        assertEquals(response.getStatusCode(),200);
    }

    @Then("I Retrieve the ConfigId {string}")
    public void iRetrieveTheConfigId(String arg0) {


    }
}
