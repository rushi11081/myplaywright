package ff;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Postdata {

	public static void main(String[] args)
	{
		
             RestAssured.baseURI="https://reqres.in/api/users";
		 
		 RequestSpecification httprequest=RestAssured.given();
		 
		 JSONObject json=new JSONObject();
		 
		 json.put("name","raja");
		 
		 json.put("job", "qa");
		
		 
		 httprequest.header("content_Type","application/json");
		 
		 httprequest.body(json.toJSONString());
		 
				 
		 Response res=httprequest.request(Method.POST,"/users");
		 
		 
		int statuscode=res.getStatusCode();
		
		System.out.println("statuscode is "+statuscode);
		
		
		/*RestAssured.baseURI="https://reqres.in/api";
		
		 RequestSpecification httprequest1=RestAssured.given();
		 
		 Response res1=httprequest.request(Method.GET,"/users/2");
		 
		 String getresponse=res1.getBody().asString();
			
		 System.out.println("The Response is  "+ getresponse);*/
		
	
	}
}
