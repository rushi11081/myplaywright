package pojo1;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

public class Placeapi {

	private String name;
	
	private int accuracy;
	
	private String phone_number;
	
	private String address;
	
	private String language;
	
	private String website; 
	
	private Location location;
	
	private  List<String> types;
	

	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAccuracy() 
	{
		return accuracy;
	}

	public void setAccuracy(int accuracy)
	{
		this.accuracy = accuracy;
	}

	public String getPhone_number() 
	{
		return phone_number;
	}

	public void setPhone_number(String phone_number)
	{
		this.phone_number = phone_number;
	}

	public String getAddress() 
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getLanguage() 
	{
		return language;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}

	public String getWebsite() 
	{
		return website;
	}

	public void setWebsite(String website)
	{
		this.website = website;
	}

	public Location getLocation() 
	{
		return location;
	}

	public void setLocation(Location location) 
	{
		this.location = location;
	}

	public List<String> getTypes() 
	{
		return types;
	}

	public void setTypes(List<String> types) 
	{
		this.types = types;
	}
	
	
	
}
