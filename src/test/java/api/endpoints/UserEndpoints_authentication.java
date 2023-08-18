package api.endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class UserEndpoints_authentication {
	
     static	ResourceBundle getURL()
	{
	ResourceBundle routes=ResourceBundle.getBundle("routes");//Load properties file
	return routes;
	}
	
	
	public static Response Basic_authentication( )
	{
		//String geturl=getURL().getString("get_url");
		Response response=given()
		.auth().basic("postman", "password")
		.when()
		.get(Routes_for_auth.base_url);
		return response;
	}
	public static Response Digest_authentication( )
	{
		//String geturl=getURL().getString("get_url");
		Response response=given()
		.auth().digest("postman", "password")
		.when()
		.get(Routes_for_auth.base_url);
		return response;
	}


	public static Response Premptive_authentication() {
		Response response=given()
				.auth().preemptive().basic("postman", "password")
				.when()
				.get(Routes_for_auth.base_url);
		return response;
	}


	public static Response Bearertoken_authentication() {
		String bearertoken="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";
		Response response=given()
				.headers("Authorization","Bearer"+bearertoken)
				.when()
				.get(Routes_for_auth.base_url_Git);
		return response;
	}
	

}
