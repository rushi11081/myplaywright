package ff;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import specifaction.Spec;

@SuppressWarnings("unused")
public class Getclas {

	public static void main(String[] args)
	{
		
		
		
		 RestAssured.baseURI="https://reqres.in/api";
		   
		
		 RequestSpecification httprequest=RestAssured.given();
	
		 Response res=httprequest.request(Method.GET,"/users?page=2");
	
		 
		 String getresponse=res.getBody().asString();
				
		 System.out.println("The Response is  "+ getresponse);
		 
		 
		
	}

}
