package ff;



import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetbyTestng {

	@Test
	public void getuser()
	{
		
		RestAssured.baseURI="https://reqres.in/api";
		   
		
		 RequestSpecification httprequest=RestAssured.given();
		 
		 Response res=httprequest.request(Method.GET,"/users?page=2");
		 
		 
				String getresponse=res.getBody().asString();
				
		 System.out.println("The Response is  "+ getresponse);
		
		
	}
}
