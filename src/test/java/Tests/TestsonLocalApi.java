package Tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class TestsonLocalApi {

	@Test
	public void get()
	{
	baseURI="http://localhost:3000";
		given().
		get("users").
		then().
		statusCode(200).log().all();
	}
	@Test
	public void post()
	{
	baseURI="http://localhost:3000";
	JSONObject request= new JSONObject();
	request.put("firstName","Zara");
	request.put("lastName","Bijily");
	request.put("subjectId",2);
		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("users").
		then().statusCode(201).
		log().all();
	}
	
	@Test
	public void put()
	{
	baseURI="http://localhost:3000";
	JSONObject request= new JSONObject();
	request.put("firstName","ZaraMol");
	request.put("lastName","Bijily");
	request.put("subjectId",1);
		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		put("/users/6").
		then().statusCode(200).
		log().all();
	}
	
	@Test
	public void patch()
	{
	baseURI="http://localhost:3000";
	JSONObject request= new JSONObject();
	
	request.put("lastName","Bijily"); 						// Difference on Put and patch, if we provide put as method, 
															//then we need to provide the whole request body where as in patch , we only need to provide the corresponding value
		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("/users/1").
		then().statusCode(200).
		log().all();
	}
	@Test
	public void patchsubject()
	{
	baseURI="http://localhost:3000";
	JSONObject request= new JSONObject();
	request.put("name","Automation-sel+java");
	
		given().
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("/subjects/1").		
		then().statusCode(200).		
		log().all();
	}
	@Test
	public void Delete()
	{
	baseURI="http://localhost:3000";
	
		when().
		delete("/users/5").		
		then().statusCode(200).		
		log().all();
	}
	//checking already deleted item
	@Test
	public void AlreadyDeleted()
	{
	baseURI="http://localhost:3000";
	
		when().
		delete("/users/5").		
		then().statusCode(404).		
		log().all();
	}
	
	
}
