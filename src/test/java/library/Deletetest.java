package library;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.serializer.SerializeException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Deletetest {

	@Test
	public void Test04_delete() throws SerializeException
	{

		RestAssured.baseURI="http://216.10.245.166";
 	  JsonSerializer js=JsonSerializer.DEFAULT_READABLE;
 	  
 	  Pojofordelete pd=new Pojofordelete("02493");
 	  
 	  String json=js.serialize(pd);
 	  
		 String deleteapi=given().body(json).when().delete("http://216.10.245.166/Library/DeleteBook.php")
				 .then().log().all().assertThat().statusCode(200).extract().asString();
		 
		 System.out.println("The status  is  " +deleteapi);
	}
	
	
	
	
	
}
