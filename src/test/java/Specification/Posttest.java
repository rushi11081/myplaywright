package Specification;

import org.testng.annotations.Test;

import ff.Jsoncourse;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Posttest
{
//@Test
	public void Test01_post()
	{
	
	RestAssured.baseURI="https://rahulshettyacademy.com";

	String  result= RestAssured.given().queryParam("key","qaclick123").header("Content-Type","application/json")

			
	.body(Jsoncourse.indcourse())
	.when().post("/maps/api/place/add/json").
	then().assertThat().statusCode(200). contentType("application/json").
	extract().response().asString();
	
	System.out.println(result);
	}


@Test
   public void Test02_get()
   {
	   RestAssured.baseURI="https://rahulshettyacademy.com";
	  	   	   
	   String  result= RestAssured.given().queryParam("key","qaclick123").header("Content-Type","application/json")
						
				.when().get("/maps/api/place/add/json").
				then().assertThat().statusCode(200). contentType("application/json").
				extract().response().asString();
				
				System.out.println(result);
   }



}
