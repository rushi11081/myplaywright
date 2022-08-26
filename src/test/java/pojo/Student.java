package pojo;

import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;

public class Student {

	private String name;
	private int id;
	private int age;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int id, int age) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		
		if(this.age<=0)
		{
	       throw new IllegalStateException("invalid args");
		}
		this.age = age;
	}
	
	public void msg()
	{
		System.out.print(name + " " +id  + " "+age);
	}
}
