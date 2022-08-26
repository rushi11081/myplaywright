package ff;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreports 
{

	  public static ExtentReports extent;
	  
	  public static ExtentReports getreport()
	  {
		  
		  String path=System.getProperty("user.dir")+"//Extentreports//index.html";
		  
		  ExtentSparkReporter spark=new ExtentSparkReporter(path);
		 
		  spark.config().setReportName("api testing");
		  
		  spark.config().setDocumentTitle("Extent reort of Map");
		  
		  extent=new ExtentReports();
		  
		  extent.attachReporter(spark);
		  extent.setSystemInfo("API", "MAP");
		  return extent;
		  
	  
		  
		
		  
	  }
	
	
}
