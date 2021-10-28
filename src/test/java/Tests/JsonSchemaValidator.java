package Tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class JsonSchemaValidator {

	@Test
	
	public void GetRequest()
	{
		baseURI="https://reqres.in/api";
		given().get("users?page=2").
		then().
		assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
		statusCode(200).
		log().all();
//		body("data[4].first_name", equalTo("George")).
//		body("data[5].first_name", equalTo("Rachel"));
	}
	

}
