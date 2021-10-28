package Tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.sun.xml.xsom.impl.scd.Iterators.Map;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class getPostExamples {
	
	@Test(priority=0)
	public void Get()
	{
		baseURI="https://reqres.in/api";
		given().get("users?page=2").
		then().statusCode(200).
		body("data[4].first_name", equalTo("George")).
		body("data[5].first_name", equalTo("Rachel"));
	}
	


	
	@Test(priority=1)
	public void Post()
	{
//		HashMap<String, Object> map= new HashMap<String, Object>();
//		map.put("name","Sruthi");
//		map.put("job","Teacher");
//		System.out.println(map);
		
		JSONObject request= new JSONObject();
		request.put("name","Sruthi");
		request.put("job","Teacher");
		System.out.println(request.toJSONString());
		baseURI="https://reqres.in/api";
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("users").
		then().statusCode(201).
		log().all();
	}
	
}