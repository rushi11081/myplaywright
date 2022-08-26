package library;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.serializer.SerializeException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

public class Posttest
{
	
	
	 //***********************POST BY POJO CLASS****************************************************//
   
	
      // @Test
	public void Test01_postByPojo() throws SerializeException
	{
		
    	  RestAssured.baseURI="http://216.10.245.166";
    	     	   
    	  JsonSerializer js=JsonSerializer.DEFAULT_READABLE;
    	  
    	  Pojoforlibrary p=new  Pojoforlibrary("manual2","009","108","raju1");
    	  
    	  String json=js.serialize(p);
    	  
    	 
	String result=RestAssured.given().body(json).post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
    	  
	
		System.out.println("output is "+result);
		
	JsonPath js1=new JsonPath(result);
		
		String msg=js1.getString("Msg");
				
	System.out.println("output msg   is  "+msg);
	
		Assert.assertEquals(msg, "successfully added","it is validd book");
		
			
	}
	
	 //***********************POST BY POJO CLASS****************************************************//
	
	
	 //***********************POST BY EXCEL****************************************************//
    	
      @Test
    public void Test_PostByExcel() throws IOException
    {
    	   RestAssured.baseURI="http://216.10.245.166";
    	   
    	   String datapath="C:\\Users\\Rushikesh Patil\\eclipse-workspace\\RESTASSURED\\exceldata\\library.xlsx.xlsx";
    	
    	   File excelfile=new File(datapath);
    	   FileInputStream fin=new  FileInputStream(excelfile);
    	   XSSFWorkbook workbook=new XSSFWorkbook(fin);
    	   
    	   XSSFSheet sheet=workbook.getSheetAt(0);
    	   
    	   DataFormatter dataformat=new DataFormatter();
   		   					
			Object name =dataformat.formatCellValue(sheet.getRow(1).getCell(0));
		
        	   
    	     	   
    	   Object isbn =dataformat.formatCellValue(sheet.getRow(1).getCell(1));
    	   
    	      	   
    	   Object aisle =dataformat.formatCellValue(sheet.getRow(1).getCell(2));
    	
    	   Object author =dataformat.formatCellValue(sheet.getRow(1).getCell(3));
    	   
    	  
    	   
    	   JSONObject jsondata=new  JSONObject();
    	   
    	   jsondata.put("name",name);
    	   
    	   jsondata.put("isbn",isbn);
    	   
    	   jsondata.put("aisle",aisle);
    	   
    	   jsondata.put("author",author);
    	   
    	   String result=RestAssured.given().body(jsondata).post("/Library/Addbook.php")
    				.then().log().all().assertThat().statusCode(200).extract().response().asString();
    		    	  
    			
    				System.out.println("output is "+result);
    				
    			JsonPath js1=new JsonPath(result);
    				
    				String msg=js1.getString("Msg");
    						
    			System.out.println("output msg   is  "+msg);
    			
    				Assert.assertEquals(msg, "successfully added","it is validd book");
    				
    }
    
    //***********************POST BY EXCEL*************************************************************//
    
       
    //***********************POST BY CLASS CONTENT PAYLOAD************************************************//
    
     
   //    @Test
       public void Test_PostByClasscontent()
       {
    	   RestAssured.baseURI="http://216.10.245.166";
    	   
    		 
    		String result=RestAssured.given().body(Contentofapi.dataforpost()).post("/Library/Addbook.php")
    			.then().log().all().assertThat().statusCode(200).extract().response().asString();
    	    	  
    		
    			System.out.println("output is "+result);
    			
    		JsonPath js1=new JsonPath(result);
    			
    			String msg=js1.getString("Msg");
    					
    		System.out.println("output msg   is  "+msg);
    		
    			Assert.assertEquals(msg, "successfully added","it is validd book");
       }
       
       
       //***********************POST BY CLASS CONTENT PAYLOAD****************************//
       
       
      // @DataProvider(name="addbook")
     
       public Object[][] dataforaddbook()
       {
    	   
    	   Object[][] data= new Object[2][4];
    	   
    	   data[0][0]="maven2";
    	   
    	   data[0][1]="987654";
    	   
    	   data[0][2]="m25";
    	   
    	   data[0][3]="dh";
    	   
    	   
    	   
       data[1][0]="maven3";
    	   
    	   data[1][1]="987";
    	   
    	   data[1][2]="m26";
    	   
    	   data[1][3]="dh1";
    	   
		return data;
    	   
       }
       
     
       //***********************POST BY DATAPROVIDER****************************//
    //   @Test(dataProvider="addbook")
   	public void postdataprovidertest(String fname,String isbn,String aisle,String author)
   	{
   	
   		RestAssured.baseURI="http://216.10.245.166";
   		
   		JSONObject req=new JSONObject();
   		
   		req.put("name",fname);
   		
   		req.put("isbn",isbn);
   		
   		req.put("aisle",aisle);
   		
   		req.put("author",author);
   		
   		
   		
   		String result=given().contentType(ContentType.JSON).accept(ContentType.JSON)
   		.body(req.toJSONString()).when().post("/Library/Addbook.php").then()
   		.statusCode(200).log().all().extract().response().asString();
   		
   		
   		System.out.println("output is "+result);
		
		JsonPath js1=new JsonPath(result);
			
			String msg=js1.getString("Msg");
					
		System.out.println("output msg   is  "+msg);
		
			Assert.assertEquals(msg, "successfully added","it is validd book");
   	}
       
       //***********************POST BY DATAPROVIDER****************************//
       
}
