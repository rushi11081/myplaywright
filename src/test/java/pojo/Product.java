package pojo;

import java.beans.BeanProperty;
import java.util.Arrays;

import org.apache.juneau.annotation.Beanc;

public class Product {

	private String name;
	private int price;
	private String color;
	private String[] sellername;
	
	
	@Beanc(properties="name,price,color,sellername")
		public Product(String name, int price, String color, String[] sellername) {
		
		this.name = name;
		this.price = price;
		this.color = color;
		this.sellername = sellername;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String[] getSellername() {
		return sellername;
	}


	public void setSellername(String[] sellername) {
		this.sellername = sellername;
	}


	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", color=" + color + ", sellername="
				+ Arrays.toString(sellername) + "]";
	}


	
	
	
}
