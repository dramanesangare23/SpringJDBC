package com.tutorialspoint;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("application-context.xml");
		StudentJDBCTemplate studentJDBCTemplate = 
				(StudentJDBCTemplate)applicationContext.getBean("studentJDBCTemplate");

		System.out.println("------Records Creation--------" ); 
		studentJDBCTemplate.create("WarLord", 11); 
		studentJDBCTemplate.create("BlackSamuraï", 2); 
		studentJDBCTemplate.create("Nakamura", 15);

		System.out.println("------Listing Multiple Records--------" ); 
		List<Student> students = studentJDBCTemplate.listStudents(); 
		for (Student record : students) {
			System.out.print("ID : " + record.getId() ); 
			System.out.print(", Name : " + record.getName() ); 
			System.out.println(", Age : " + record.getAge()); 
		}
		
		System.out.println("----Updating Record with ID = 2 -----" ); 
		studentJDBCTemplate.update(2, 20); 
		
		System.out.println("----Listing Record with ID = 2 -----" ); 
		Student student = studentJDBCTemplate.getStudent(2); 
		System.out.print("ID : " + student.getId() ); 
		System.out.print(", Name : " + student.getName() );
		System.out.print(", Age : " + student.getAge() );
		
		System.out.println("----Deleting Record with ID = 5 -----" ); 
		studentJDBCTemplate.delete(5);

		System.out.println("------Listing Multiple Records--------" ); 
		students = studentJDBCTemplate.listStudents(); 
		for (Student record : students) {
			System.out.print("ID : " + record.getId() ); 
			System.out.print(", Name : " + record.getName() ); 
			System.out.println(", Age : " + record.getAge()); 
		}
		
		((AbstractApplicationContext)applicationContext).close();

	}

}
