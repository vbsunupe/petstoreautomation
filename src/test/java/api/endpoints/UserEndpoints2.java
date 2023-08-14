package api.endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class UserEndpoints2 {
	
     static	ResourceBundle getURL()
	{
	ResourceBundle routes=ResourceBundle.getBundle("routes");//Load properties file
	return routes;
	}
	
	public static Response createUser(User payload)
	{
		String posturl=getURL().getString("post_url");
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(posturl);
		return response;
	}
	public static Response readUser(String userName)
	{
		String geturl=getURL().getString("get_url");
		Response response=given()
		.pathParam("username", userName)
		.when()
		.get(geturl);
		return response;
	}
	public static Response updateUser(String userName,User payload)
	{
		String updateurl=getURL().getString("update_url");
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.pathParam("username", userName)
		.when()
		.put(updateurl);
		return response;
	}
	public static Response deleteUser(String userName)
	{
		String deleteurl=getURL().getString("delete_url");
		Response response=given()
		.pathParam("username", userName)
		.when()
		.delete(deleteurl);
		return response;
	}

}
