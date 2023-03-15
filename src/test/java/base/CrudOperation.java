package base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.Payload;
import stepDefinations.config;

import java.io.FileNotFoundException;
import java.io.IOException;

import static resources.APIResources.CreateConfig;

public class CrudOperation extends BaseBuilder{
    static Response response;
    RequestSpecification reqspec;
    private String password;
    private Object username;

    public Response performPOSTcall(String apiName) throws IOException {
        APIResources resourceAPI= APIResources.valueOf(apiName);
        System.out.println("=========================="+resourceAPI.toString());
        reqspec = new BaseBuilder().placeSpecBuilder();

        if(apiName.equalsIgnoreCase(String.valueOf(CreateConfig)))
        {
            System.out.println("Sending POST request to: "+resourceAPI.getResource()+" with body" +Payload.CreateConfigID());
            reqspec = RestAssured.given().spec(reqspec).body(Payload.CreateConfigID());
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>> request: "+reqspec.toString());
        }
        else if(apiName.equalsIgnoreCase("IamService"))
        {
            if(config.AccessToken == null) {
                config gm = new config();
                gm.userCallsWithHttpRequest("IamService", "POST");

            }
            System.out.println("Sending POST request to: "+resourceAPI.getResource()+" service");
            reqspec = RestAssured.given().spec(reqspec).body(Payload.getAccessTokenBody((String) username,password));
        }
        System.out.println("============Resorce============="+resourceAPI.getResource());
		response = reqspec.post(resourceAPI.getResource()).then().extract().response();
        System.out.println("Response :"+response.getBody());
        return response;
    }
}
