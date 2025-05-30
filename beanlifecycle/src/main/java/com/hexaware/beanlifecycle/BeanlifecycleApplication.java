package com.hexaware.beanlifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeanlifecycleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeanlifecycleApplication.class, args);
//		
//		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//	
//		Address address = ac.getBean(Address.class);
//		address.display();
//		
//		Student student = ac.getBean(Student.class);
//		student.display();
//		
//		((AbstractApplicationContext) ac).close();
		
		//try with resource block - automatically close ApplicationContext
//		try(var ac = new AnnotationConfigApplicationContext(AppConfig.class)){
//		
//			Address address = ac.getBean(Address.class);
//			address.display();
//				
//			Student student = ac.getBean(Student.class);
//			student.display();
//		}
//		org.springframework.boot.autoconfigure.web.servlet
		 
	}

}
