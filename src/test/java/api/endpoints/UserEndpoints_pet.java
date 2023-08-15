package api.endpoints;
import static io.restassured.RestAssured.given;

import java.util.Map;

import api.payload.Petpayload;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class UserEndpoints_pet {
	//Petpayload p=new Petpayload(); 
	public static Response createPet(Map<String, Object>  payload)
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.post_url_pet);
		return response;
	}


}
