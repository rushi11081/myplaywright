package pojo;

import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.parser.ParseException;
import org.apache.juneau.serializer.SerializeException;
import org.apache.juneau.xml.XmlSerializer;
import org.json.simple.parser.JSONParser;

import groovy.json.JsonParser;
import groovy.json.JsonParserType;

public class Producttest {

	public static void main(String[] args) throws SerializeException, ParseException {
		// TODO Auto-generated method stub

		// *****************************************pojo to json serialization
		
		JsonSerializer js=JsonSerializer.DEFAULT_READABLE;
		
		String sellername[]= {"abc","xyz","pqr"};
		
		Product p=new Product("laptop",25000,"white",sellername);
		
		String json=js.serialize(p);
		
		  System.out.println("THIS IS JSON FORMAT");
	    System.out.println(json);
	    
	  //********************************************pojo to xml serialization
	    
	    XmlSerializer xs= XmlSerializer.DEFAULT_NS_SQ;
	  
	    String xml=xs.serialize(p);
	    
	    System.out.println("THIS IS XML FORMAT");
	    
	  
	    System.out.println(xml)
	    
	    
	  //********************************************pojo to HTML  serialization
	    
	    
	    
	    HtmlSerializer serhtml=HtmlSerializer.DEFAULT_SQ_READABLE;
	    
	    String ht= serhtml.serialize(p);
	    
	    
	    System.out.println("THIS IS HTML FORMAT");
	    System.out.println(ht);
	    // *********************************************deserialization Json to POJO
	    
		
		  org.apache.juneau.json.JsonParser jp
		  =org.apache.juneau.json.JsonParser.DEFAULT;
		  
		  
		  
		  String jsonval=" {\r\n" + "	\"color\": \"white\",\r\n" +
		  "	\"name\": \"laptop\",\r\n" + "	\"price\": 25000,\r\n" +
		  "	\"sellername\": [\r\n" + "		\"abc\",\r\n" + "		\"xyz\",\r\n" +
		  "		\"pqr\"\r\n" + "	]\r\n" + "}"; Product p2=jp.parse(jsonval,
		  Product.class);
		  
		  System.out.println(p2.getColor());
		  
		  System.out.println("THIS IS POJO FORMAT");
		  System.out.println(p2);
		 
	    
	    
	}

	
	
	
	
	

}
