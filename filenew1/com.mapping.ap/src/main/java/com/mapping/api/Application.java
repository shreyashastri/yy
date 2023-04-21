package com.mapping.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mapping.api.entity.Student;
import com.mapping.api.entity.Subject;
import com.mapping.api.repository.StudentRepository;

@SpringBootApplication 
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		}
	
	@Autowired 
	private StudentRepository  studentRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Student student = new Student("Madhav", "CSE");

		Subject subject1 = new Subject("Math");
		Subject subject2 = new Subject("English");
		Subject subject3 = new Subject("Science");

		student.getSubject().add(subject1);
        student.getSubject().add(subject2);
        student.getSubject().add(subject3);
        
        
        this.studentRepository.save(student); 
		
		}

}
