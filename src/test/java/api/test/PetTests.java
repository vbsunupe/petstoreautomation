package api.test;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints_pet;
import api.payload.Petpayload;
import api.payload.User;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class PetTests {
	UserEndpoints_pet up;
	Petpayload petpayload;
	public Logger logger;
	@BeforeClass
	public void setup() {

	//logs
	logger=LogManager.getLogger(this.getClass());
	}
	@Test(priority=1)
	public void testcreatepet() {
	logger.info("******Creating pet***********");
	Response response=UserEndpoints_pet.createPet(petpayload.payloadofpet());
	response.then().log().all();
	//Assert.assertEquals(response.getStatusCode(),200);
	logger.info("******pet  is created****");
	response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("petschema.json"));
	Assert.assertEquals(response.getHeader("Content-Type"),"application/json");
	Assert.assertEquals(response.getHeader("Connection"),"keep-alive");
	Assert.assertEquals(response.getHeader("Server"),"Jetty(9.2.9.v20150224)");
	Assert.assertEquals(response.getHeader("Access-Control-Allow-Methods"),"GET, POST, DELETE, PUT");
		
	}
	
	
	
}
