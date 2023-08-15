package api.payload;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Petpayload {
	@Test
	public static Map<String, Object> payloadofpet() {

		//List<Map<String,Object>>payload=new ArrayList<Map<String,Object>>();
		Map<String,Object>jsonobject=new HashMap<String,Object>();
		jsonobject.put("id",922337203);//id

		Map<String,Object>category =new HashMap<String,Object>();
		category.put("id", 1);
		category.put("name", "catat");

		jsonobject.put("category", category);//categury

		Map<String,String>photo=new HashMap<String,String>();
		photo.put("1", "https://jsoneditoronline.org/#left=local.begeno&right=local.juhaza");

		List<Object>photoUrls=new ArrayList<Object>();
		photoUrls.add(photo);
		jsonobject.put("photoUrls", photoUrls);

		jsonobject.put("name","cat1");//name


		Map<String,Object>tag=new HashMap<String,Object>();
		tag.put("id", 1);
		tag.put("name", "cat123");
		List<Object>tags=new ArrayList<Object>();
		tags.add(tag);

		jsonobject.put("tags", tags);


		jsonobject.put("status","available");//status





		return jsonobject;

		//RestAssured.given().log().all().body(jsonobject).get();

	}


}