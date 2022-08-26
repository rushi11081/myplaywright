package ff;

import io.restassured.path.json.JsonPath;

public class Jsonassing 
{

	
	public static int totalprice;
	
	public static void main(String[] args) 
	{
		

		
		JsonPath js=new JsonPath(Jsoncourse.indcourse());
		
		//System.out.println(js.get("courses[2].title"));
		
		//System.out.println(js.get("courses[2].price"));
		
		int amt=js.get("dashboard.purchaseAmount");
		
		//System.out.println(amt);
		
		int size=js.get("courses.size()");
		
		//System.out.println(size);
		
		for(int j=0;j<size;j++)
		{
			
			String cname=js.getString("courses["+j+"].title");
			
		//	System.out.println(cname);
			
			int price=js.getInt("courses["+j+"].price");
			
			int qty=js.getInt("courses["+j+"].copies");
			
			totalprice= totalprice + price*qty;
			

			
			
		}
		System.out.println(totalprice);
		
		if(totalprice==amt)
		{
			System.out.println("amount match");
}
	else
	{
		System.out.println("amount not match");
	}
}}