package com.spring.jdbc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.Scanner;

	public class App
	{
	   

		public static void main( String[] args )
	    {
	         
	        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	        JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
	        
	      
	        	        Scanner sc=new Scanner(System.in);
	        	        System.out.println("1:Insert 2:Delete 3:Update 4:Exit");
	        	        
	        	       
	        	        do {
	        	        	 int n=sc.nextInt();
	        	        switch(n) {
	        	        
	        	        case 1:String query1="insert into student(id,name,city) value(?,?,?)";
	        	        System.out.println("Enter the id,name,city");
	        	        int n1=sc.nextInt();
	        	        String s1=sc.next();
	        	        String s2=sc.next();
	        	     
	        	        
	        	        int result1=template.update(query1,n1,s1,s2);
	        	        System.out.println("Number of records inserted.. "+ result1);
	        	        break;
	        	        //delete
	        	        case 2:String query2="delete from student where id=?";
	        	        System.out.println("enter student to be deleted");
	        	        int n2=sc.nextInt();
	        	        int result2=template.update(query2,n2);
	        	        System.out.println("Number of records deleted.. "+ result2);
	        	        break;
	        	        //update
	        	        case 3:
	        	        	System.out.println("Enter studentId to be updated");
	        	        	int n3=sc.nextInt();
	        	        	System.out.println("Enter student values  to be updated 1.name 2.city");
	        	        	int k=sc.nextInt();
	        	        	switch(k) {
	        	        	case 1:
	        	        		String s4=sc.next();
	        	        		String query3="update student set name=? where id=?";
	        	        		int result3=template.update(query3,s4,n3);
	        	        		System.out.println("Number of records deleted.. "+ result3);
	        	        		break;
	        	        	case 2:
	        	        		String s5=sc.next();
	        	        		String query4="update student set city=? where id=?";
	        	        		int result4=template.update(query4,s5,n3);
	        	        		System.out.println("Number of records deleted.. "+ result4);
	        	        		break;
	        	        	
	        	        	
	        	        	
	        	        	}
	        	       
	        	      
	        	        case 4:java.lang.System.exit(0);
	        	        break;
	        	        
	        	        }
	        	        } while(true);
	        	        
	        	        
	    }
	}
