package specifaction;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import ff.Payload;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Testpost {

	//@Test
	public void test1_post()
	{
		
		 RestAssured.baseURI="https://rahulshettyacademy.com";
		 
		 Response res= given().queryParam("key", "qaclick123")
				 
		 .body(Payload.body())
		 .when().post("/maps/api/place/add/json").
		 
		 then().assertThat().statusCode(200).
		 
		 extract().response();
		 
		 int statuscode=res.getStatusCode();
		 
		 Assert.assertEquals(statuscode, 200);
		
	}
	
	
	
	@Test
	public void test2_get()
	{
		
		 RestAssured.baseURI="https://rahulshettyacademy.com";
		 
		 String res= given().queryParam("key","qaclick123").header("Content-Type","application/json")
				 
		 
		 .when().get("/maps/api/place/add/json").
		 
		 then().assertThat().statusCode(200).
		 
		 extract().response().asString();
		 
		 //int statuscode=res.getStatusCode();
		 
		// String result=res.body().asString();
		 
		 //Assert.assertEquals(statuscode, 200);
		 
		 System.out.println("the response is "+res);
		
	}
	
	
	
	
	
}
