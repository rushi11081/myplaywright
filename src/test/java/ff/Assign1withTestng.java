package ff;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import pojo1.Location;
import pojo1.Placeapi;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.protocol.RequestAuthCache;
import org.json.simple.JSONObject;

public class Assign1withTestng 
{
    String str=null;
	@Test(priority=1)
   public void Test01_post() throws FileNotFoundException
   {
	   
		RestAssured.baseURI="https://rahulshettyacademy.com";
		   
		   PrintStream addplacelog1=new PrintStream(new FileOutputStream("./src/main/resources/addplace3.txt"));
		   		  
		   Placeapi locapi=new Placeapi();
		   locapi.setAccuracy(50);
		   locapi.setName("raju");
		   locapi.setAddress("sangli");
		   locapi.setLanguage("german");
		   locapi.setPhone_number("9881444160");
		   locapi.setWebsite("http://google.com");
		   
		   Location l1=new Location();
		   
		   l1.setLat(345.666);
		   l1.setLng(456.23);
		   
		   locapi.setLocation(l1);
		   
		   List<String> types=new ArrayList<String>();
		   
		   types.add("test one");
		   
		   types.add("test two");
		   
		   locapi.setTypes(types);
		   
		 String result=given().log().all().queryParam("key","qaclick123").body(locapi)
				 .filter(RequestLoggingFilter.logRequestTo(addplacelog1))
				 .filter(ResponseLoggingFilter.logResponseTo(addplacelog1)).when().
				 post("/maps/api/place/add/json").
				 then().log().all().assertThat().statusCode(200)
				 .extract().response().asString();
				 
		 System.out.println(result);
		 
		
		 
	 JsonPath js=new JsonPath(result);
		 
	 str=js.getString("place_id");
	 
	 String scope=js.getString("scope");
		 
	 System.out.println(scope);
	 
	Assert.assertEquals(scope, "APP");
	
	 
          
   }
	
	
	@Test(priority=2)
	public void Test02_get() throws FileNotFoundException
	{

		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		
		String getresponse=given().log().all().queryParam("key", "qaclick123").queryParam("place_id",str).header("content_Type","application/json")
				.when().get("/maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract().response().asString();
				
				
		 System.out.println("The Response is  "+ getresponse);
		
		
	}
	
	
	@Test(priority=3)
	public void Test03_Put() throws FileNotFoundException
	{

		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		JSONObject req=new JSONObject();
		
		req.put("name","rajesh");
		
		
		Response result=given().header("Content-Type","application/json").contentType(ContentType.JSON).accept(ContentType.JSON).queryParam("key","qaclick123")
		 .body(req.toJSONString()).when().put("/maps/api/place/update/json").then().statusCode(200).log().all();
		
		
		System.out.println(result);
		
	}
	
	@Test(priority=3)
	public void Test04_Delete()
	{

		 String deleteapi=given().log().all().queryParam("key", "qaclick123").body( "{\r\n"+ "\"place_id\":\""+str+"\"\r\n"+"}").when().delete("/maps/api/place/delete/json")
				 .then().log().all().assertThat().statusCode(200).extract().asString();
		 
		 System.out.println("The status  is  " +deleteapi);
		
	}
	
	
	
	
	
	
	
}
