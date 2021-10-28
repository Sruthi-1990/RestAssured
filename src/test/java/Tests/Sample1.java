package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Sample1 {
@Test
	public void Test_1()
	{
		Response response=get("https://reqres.in/api/users?page=2");
		int sC=response.getStatusCode();		
		System.out.println(response.getStatusCode());
	
		System.out.println(response.getTime());
		
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		response.getHeader("content-type");
		Assert.assertEquals(sC,200);
	}
@Test
public void Test_2()
{
	baseURI="https://reqres.in/api";
	given().get("/users?page=2").
	then().statusCode(200).
	body("data[1].id", equalTo(8)).log().all();

}
}
