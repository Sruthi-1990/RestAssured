package Tests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class SOAPXMLRequest {
	@Test
	public void validateSOAPXML() throws IOException 
	{
		File file=new File("./SOAPRequestFile/Add.xml");
		String	RequestBody = null;
		
		if(file.exists())
		System.out.println("File Exists");
		
		FileInputStream f=new FileInputStream(file);
		RequestBody = IOUtils.toString(f, "UTF-8");
	
		baseURI="http://www.dneonline.com";		
		given().
		contentType("text/xml").
		accept(ContentType.XML).
		body(RequestBody).
		when().
		post("calculator.asmx").
		then().
		statusCode(200).
		log().all();
		
		
	}

}
