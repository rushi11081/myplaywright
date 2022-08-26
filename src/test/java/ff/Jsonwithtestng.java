package ff;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class Jsonwithtestng 

{
	public static int totalprice;

	@Test
	public void get()
	{
		
		JsonPath js=new JsonPath(Jsoncourse.indcourse());
		
				
		int amt=js.get("dashboard.purchaseAmount");
		
		
		int size=js.get("courses.size()");
		
		
		
		for(int j=0;j<size;j++)
		{
			
			String cname=js.getString("courses["+j+"].title");
			
		
			
			int price=js.getInt("courses["+j+"].price");
			
			int qty=js.getInt("courses["+j+"].copies");
			
			totalprice= totalprice + price*qty;
			

			
			
		}
		System.out.println(totalprice);
		
		
		Assert.assertEquals(totalprice, amt);
	}
	
}
