package pojo;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student s1=new Student("raju",200,40);
		
		s1.msg();
		
		Student s2=new Student();
		

		s2.setName("rishi");
	
	    s2.setId(400);
	    
	    s2.setAge(-30);
	    
	   System.out.println(s2.getName());
	   
	   System.out.println(s2.getId());
	   
	   System.out.println(s2.getAge());
	}

}
