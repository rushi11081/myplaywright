package library;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetTest {

	
	@Test
	public void Test01_get()
	{
		
				
		given().when()
		.get("http://216.10.245.166/Library/GetBook.php?AuthorName=raju1").then().assertThat()
		.statusCode(200).and().header("Content-Type","application/json");
		 
	}
	
	
	
//	@Test
	public void Test02_get()
	{
		
				
		 RestAssured.baseURI="http://216.10.245.166";
		   
			
		 RequestSpecification httprequest=RestAssured.given();
	
		 Response res=httprequest.request(Method.GET,"/Library/GetBook.php?AuthorName=raju1");
	
		 
		 String getresponse=res.getBody().asString();
				
		 System.out.println("The Response is  "+ getresponse);
		 
	}
	
	@Test
	public void Test03_get()
	{
		
	
		
		
	 RestAssured.baseURI="http://216.10.245.166";
		   
			
		 RequestSpecification httprequest1=RestAssured.given();
	
		 Response res1=httprequest1.request(Method.GET,"/Library/GetBook.php?ID=009108");
	
		 
		 String getresponse1=res1.getBody().asString();
				
		 System.out.println("The Response is  "+ getresponse1);
		 
		 int statuscode=res1.getStatusCode();
		 
		 Assert.assertEquals(statuscode, 200);
	
		 
		 
	}
	
	
	
	
	
	
}
