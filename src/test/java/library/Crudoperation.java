package library;

import static io.restassured.RestAssured.given;

import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.serializer.SerializeException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Crudoperation {

	@Test(priority=1)
	public void Test01_Post() throws SerializeException
	{
		 RestAssured.baseURI="http://216.10.245.166";
   	   
   	  
		 JsonSerializer js=JsonSerializer.DEFAULT_READABLE;
   	  
   	  Pojoforlibrary p=new  Pojoforlibrary("bio","01","11","kd");
   	  
   	  String json=js.serialize(p);
			String result=RestAssured.given().body(json).post("/Library/Addbook.php")
				.then().log().all().assertThat().statusCode(200).extract().response().asString();
		    	  
				System.out.println(result);
	}
	
	@Test(priority=2)
	public void Test02_getbyauthor()
	{
		
	
		
		
		 RestAssured.baseURI="http://216.10.245.166";
		   
			
		 RequestSpecification httprequest=RestAssured.given();
	
		 Response res=httprequest.request(Method.GET,"/Library/GetBook.php?AuthorName=kd");
	
		 
		 String getresponse=res.getBody().asString();
				
		 System.out.println("The Response is  "+ getresponse);
		 
	}
	
	
	@Test(priority=3)
	public void Test03_getbyID()
	{
		
		
		
	 RestAssured.baseURI="http://216.10.245.166";
		   
			
		 RequestSpecification httprequest1=RestAssured.given();
	
		 Response res1=httprequest1.request(Method.GET,"/Library/GetBook.php?ID=0111");
	
		 
		 String getresponse1=res1.getBody().asString();
				
		 System.out.println("The Response is  "+ getresponse1);
		
	 		 
	}
	
	
	@Test(priority=4)
	public void Test04_delete() throws SerializeException
	{
		
		RestAssured.baseURI="http://216.10.245.166";
	 	  JsonSerializer js=JsonSerializer.DEFAULT_READABLE;
	 	  
	 	  Pojofordelete pd=new Pojofordelete("0111");
	 	  
	 	  String json=js.serialize(pd);

		 
		 String deleteapi=given().body(json).when().delete("http://216.10.245.166/Library/DeleteBook.php")
				 .then().log().all().assertThat().statusCode(200).extract().asString();
		 
		 System.out.println("The status  is  " +deleteapi);
	}
	
	
	
}
