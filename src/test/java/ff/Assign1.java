package ff;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import pojo1.Location;
import pojo1.Placeapi;

import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

public class Assign1
{

	public static void main(String[] args) throws FileNotFoundException
	{
 
 
   RestAssured.baseURI="https://rahulshettyacademy.com";
   
   PrintStream addplacelog1=new PrintStream(new FileOutputStream("./src/main/resources/addplace2.txt"));
   // This is Post API 
  
   Placeapi locapi=new Placeapi();
   locapi.setAccuracy(50);
   locapi.setName("rushikesh");
   locapi.setAddress("sangola");
   locapi.setLanguage("english");
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
 String str=js.getString("place_id");

  //System.out.println(str);
  
 // This is Get Api //
 String getresponse=given().log().all().queryParam("key", "qaclick123").queryParam("place_id",str).header("content_Type","application/json")
			.when().get("/maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract().response().asString();
			
			
	 System.out.println("The Response is  "+ getresponse);
	
	 
	 
	 // This is delete API//
	 
	 String deleteapi=given().log().all().queryParam("key", "qaclick123").body( "{\r\n"+ "\"place_id\":\""+str+"\"\r\n"+"}").when().delete("/maps/api/place/delete/json")
			 .then().log().all().assertThat().statusCode(200).extract().asString();
	 
	 System.out.println("The status  is  " +deleteapi);
	
	}
}