package Tests;

import static io.restassured.RestAssured.*;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class putPatchDelete {
	@Test	
	public void Put()
	{

	
		JSONObject request= new JSONObject();
		request.put("name","Sruthi");
		request.put("job","Doctor");
		System.out.println(request.toJSONString());
		baseURI="https://reqres.in";
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		put("api/users/2").
		then().statusCode(200).
		log().all();
	
	}
	@Test	
	public void Patch()
	{

	
		JSONObject request= new JSONObject();
		request.put("name","Sruthi");
		request.put("job","Architect");
		System.out.println(request.toJSONString());
		baseURI="https://reqres.in";
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("api/users/2").
		then().statusCode(200).
		log().all();
	
	}
	@Test	
	public void delete()
	{

	
		
		baseURI="https://reqres.in";
				
		when().
		delete("api/users/2").
		then().statusCode(204).
		log().all();
	
	}

}
