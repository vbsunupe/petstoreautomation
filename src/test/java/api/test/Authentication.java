package api.test;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints_authentication;
import api.payload.User;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Authentication {

	public Logger logger;
	@BeforeClass
	public void setup() {


		//logs
		logger=LogManager.getLogger(this.getClass());
	}
	@Test(priority=1)
	public void test_BASICAUTH() {

		Response response=UserEndpoints_authentication.Basic_authentication();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("******Api is authenticated****");
		//response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("petstoreusermodule.json"));
		Assert.assertEquals(response.getHeader("Content-Type"),"application/json; charset=utf-8");
		Assert.assertEquals(response.getHeader("Connection"),"keep-alive");
		String message=response.jsonPath().getString("authenticated").toString();
		Assert.assertEquals(message, "true");
		logger.info("******message verified****");

	}
	@Test(priority=2)
	public void test_DigestAUTH() {

		Response response=UserEndpoints_authentication.Digest_authentication();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("******Api is authenticated****");
		//response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("petstoreusermodule.json"));
		Assert.assertEquals(response.getHeader("Content-Type"),"application/json; charset=utf-8");
		Assert.assertEquals(response.getHeader("Connection"),"keep-alive");
		String message=response.jsonPath().getString("authenticated").toString();
		Assert.assertEquals(message, "true");
		logger.info("******message verified****");

	}
	@Test(priority=3)
	public void test_PremptiveAUTH() {

		Response response=UserEndpoints_authentication.Premptive_authentication();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("******Api is authenticated****");
		//response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("petstoreusermodule.json"));
		Assert.assertEquals(response.getHeader("Content-Type"),"application/json; charset=utf-8");
		Assert.assertEquals(response.getHeader("Connection"),"keep-alive");
		String message=response.jsonPath().getString("authenticated").toString();
		Assert.assertEquals(message, "true");
		logger.info("******message verified****");

	}
	@Test(priority=4)
	public void test_BearertokenAUTH() {

		Response response=UserEndpoints_authentication.Bearertoken_authentication();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("******Api is authenticated****");
		//response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("petstoreusermodule.json"));
		Assert.assertEquals(response.getHeader("Content-Type"),"application/json; charset=utf-8");
		Assert.assertEquals(response.getHeader("Connection"),"keep-alive");
		String message=response.jsonPath().getString("authenticated").toString();
		Assert.assertEquals(message, "true");
		logger.info("******message verified****");

		

	}



}
