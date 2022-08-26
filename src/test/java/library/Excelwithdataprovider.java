package library;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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

public class Excelwithdataprovider
{
	
	public Object name;
	   
	   Object isbn;
	   Object aisle;
	   Object author;
	   
  
   @Test(dataProvider="addbook")
	public void get() throws IOException
	{
		
	   RestAssured.baseURI="http://216.10.245.166";
	   
	   String datapath="C:\\Users\\Rushikesh Patil\\eclipse-workspace\\RESTASSURED\\exceldata\\library.xlsx.xlsx";
	
	   File excelfile=new File(datapath);
	   FileInputStream fin=new  FileInputStream(excelfile);
	   XSSFWorkbook workbook=new XSSFWorkbook(fin);
	   
	   XSSFSheet sheet=workbook.getSheetAt(0);
	   
	   DataFormatter dataformat=new DataFormatter();
		   					
		 name =dataformat.formatCellValue(sheet.getRow(1).getCell(0));
	  	   
	     	   
	   isbn =dataformat.formatCellValue(sheet.getRow(1).getCell(1));
	   
	    	   
	    aisle =dataformat.formatCellValue(sheet.getRow(1).getCell(2));
	
	    author =dataformat.formatCellValue(sheet.getRow(1).getCell(3));
	   
	JSONObject req=new JSONObject();
   		
   		req.put("name",name);
   		
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
   
   @DataProvider(name="addbook")
   
   public Object[][] dataforaddbook()
   {
	   
	   Object[][] data= new Object[2][4];
	   
	   data[0][0]="name";
	   
	   data[0][1]="isbn";
	   
	   data[0][2]="aisle";
	   
	   data[0][3]="author";
	   
	   
	
	   
	return data;
	   
   }
	
}
