package utilities;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


public class Utilities {
	
//	public static JsonPath rawToJson(Response response) {
//		JsonPath js = new JsonPath((response);
//		return js;
//	}

	public String getJsonPath(Response response)
	{
		String resp=response.asString();
		JsonPath   js = new JsonPath(resp);
		return js.get().toString();
	}
}

