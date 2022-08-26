package library;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Libapibyparameter

{

	@Parameters({"name","isbn","aisle","author"})
	@Test
	public void test(String name,String isbn,String aisle,String author)
	{
		 RestAssured.baseURI="http://216.10.245.166";
		 
          JSONObject req=new JSONObject();
   		
   		req.put("name",name);
   		
   		req.put("isbn",isbn);
   		
   		req.put("aisle",aisle);
   		
   		req.put("author",author);
   		

  	 
		
		String result=RestAssured.given().body(req).post("/Library/Addbook.php")
			.then().log().all().assertThat().statusCode(200).extract().response().asString();
	    	  
		
			System.out.println("output is "+result);
			
		JsonPath js1=new JsonPath(result);
			
			String msg=js1.getString("Msg");
					
		System.out.println("output msg   is  "+msg);
		
			Assert.assertEquals(msg, "successfully added","it is validd book");
		
	}
	
	
	
	
}
