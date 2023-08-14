package api.test;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class UserTests {
	Faker faker;
	User userpayload;
	public Logger logger;
	@BeforeClass
	public void setup() {
	faker=new Faker();
	userpayload=new User();
	userpayload.setId(faker.idNumber().hashCode());
	userpayload.setUsername(faker.name().firstName());
	userpayload.setLastname(faker.name().lastName());
	userpayload.setEmail(faker.internet().safeEmailAddress());
	userpayload.setPassword(faker.internet().password(5, 10));
	userpayload.setPhone(faker.phoneNumber().cellPhone());
	
	//logs
	logger=LogManager.getLogger(this.getClass());
	}
	@Test(priority=1)
	public void testPostUser() {
	logger.info("******Creating user***********");
	Response response=UserEndpoints.createUser(userpayload);
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(),200);
	logger.info("******User is created****");
	response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("petstoreusermodule.json"));
	Assert.assertEquals(response.getHeader("Content-Type"),"application/json");
	Assert.assertEquals(response.getHeader("Connection"),"keep-alive");
	Assert.assertEquals(response.getHeader("Server"),"Jetty(9.2.9.v20150224");
	Assert.assertEquals(response.getHeader("Access-Control-Allow-Methods"),"GET, POST, DELETE, PUT");
		
	}
	@Test(priority=2)
	public void testGetUserbyName() {
		logger.info("******READING USER INFO****");
		Response response=UserEndpoints.readUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("******READING USER INFO****");
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("petstoreusermodule.json"));
		logger.info("******json schema is validated****");
		Assert.assertEquals(response.getHeader("Content-Type"),"application/json");
		Assert.assertEquals(response.getHeader("Connection"),"keep-alive");
		Assert.assertEquals(response.getHeader("Server"),"Jetty(9.2.9.v20150224)");
		Assert.assertEquals(response.getHeader("Access-Control-Allow-Methods"),"GET, POST, DELETE, PUT");
			
	}
	@Test(priority=3)
	public void testUpdateUserbyName() {
		userpayload.setUsername(faker.name().firstName());
		userpayload.setLastname(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		Response response=UserEndpoints.updateUser(this.userpayload.getUsername(),userpayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("******USER IS UPDATED****");
		//checking data after update
		Response responseAfterUpdate=UserEndpoints.readUser(this.userpayload.getUsername());
		response.then().log().all();
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("petstoreusermodule.json"));
		Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);
		Assert.assertEquals(response.getHeader("Content-Type"),"application/json");
		Assert.assertEquals(response.getHeader("Connection"),"keep-alive");
		Assert.assertEquals(response.getHeader("Server"),"Jetty(9.2.9.v20150224");
		Assert.assertEquals(response.getHeader("Access-Control-Allow-Methods"),"GET, POST, DELETE, PUT");
			
	}
	@Test(priority=4)
	public void testDeleteUserByname() {
		logger.info("******DELETING USER****");
		Response response=UserEndpoints.deleteUser(this.userpayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("******USER IS DELETED****");
		
	}
	
	
}
