package library;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Libextentreport {

	public static ExtentReports extent;
	  
	  public static ExtentReports getreport()
	  {
		  
		  String path=System.getProperty("user.dir")+"//libreport//index.html";
		  
		  ExtentSparkReporter spark=new ExtentSparkReporter(path);
		 
		  spark.config().setReportName("api testing");
		  
		  spark.config().setDocumentTitle("Extent reort of Library");
		  
		  extent=new ExtentReports();
		  
		  extent.attachReporter(spark);
		  extent.setSystemInfo("API", "library");
		  return extent;
		  
	  
		  
		
		  
	  }
	
}
