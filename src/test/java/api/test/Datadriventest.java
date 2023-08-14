package api.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.Dataproviders;
import io.restassured.response.Response;

public class Datadriventest {
	@Test(priority=1,dataProvider="Data",dataProviderClass=Dataproviders.class)	
	public void testPostuser(String userID,String userName,String fname,String lname,String useremail,String pwd,String Phone) {

		User userpayload=new User();
		userpayload.setId(Integer.parseInt(userID));
		userpayload.setUsername(userName);
		userpayload.setFirstName(fname);
		userpayload.setLastname(lname);
		userpayload.setEmail(useremail);
		userpayload.setPassword(pwd);
		userpayload.setPhone(Phone);

		Response response=UserEndpoints.createUser(userpayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=2,dataProvider="UserNames",dataProviderClass=DataProvider.class,enabled=false)	
	public void testDeleteuserByname(String userName) {
    Response response=UserEndpoints.deleteUser(userName);
    Assert.assertEquals(response.getStatusCode(), 200);
	}
	 
	

}