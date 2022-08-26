package specifaction;

import static io.restassured.RestAssured.given;

import ff.Payload;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Requestspec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		  RestAssured.baseURI="https://rahulshettyacademy.com";
		   
		//RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").build();
		
		//ResponseSpecification response=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		String result=given().spec(Spec.request()).body(Payload.body()).when().post("/maps/api/place/add/json")
				
				          .then().log().all().spec(Spec.response()).extract().response().asString();
			
		System.out.println(result);
		 
		 JsonPath js=new JsonPath(result);
		 
		 String str=js.getString("place_id");

	 
		 System.out.println("place id is ="+str);
	 
	 
		 RestAssured.baseURI="https://rahulshettyacademy.com";
				 
		 Response res=given().queryParam(key,qaclick123)
		 .body(Payload.body())
		 .when().post("/maps/api/place/add/json").
		 then().assertThat().statusCode(200).
		 extract().response();
		 
	}

}
