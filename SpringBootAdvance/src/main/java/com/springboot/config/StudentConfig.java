package com.springboot.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.springboot.Interceptor.RequestHeaderInterceptor;
import com.springboot.model.Student;

@Configuration
public class StudentConfig implements WebMvcConfigurer {

	@Autowired
	RequestHeaderInterceptor reqHeaderInterceptor;

	@Bean(name = "student1")
	Student student1() {
		return new Student("Xyz", "Pune", 1, "8912346710", "xyz@mail.com");
	}

	@Bean(name = "student2")
	public Student student2() {
		return new Student("ABC", "Mumbai", 2, "9988776655", "abc@hotmail.com");
	}

	@Bean(name = "student3")
	public Student student3() {
		return new Student("PQR", "Bangalore", 3, "8710462300", "pqr@outlook.com");
	}

	@Bean
	public List<Student> studentList() {
		return Arrays.asList(new Student("Xyz", "Pune", 1, "8912346710", "xyz@mail.com"),
				new Student("ABC", "Mumbai", 2, "9988776655", "abc@hotmail.com"),
				new Student("PQR", "Bangalore", 3, "8710462300", "pqr@outlook.com"));
	}

	/*@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(reqHeaderInterceptor);
		WebMvcConfigurer.super.addInterceptors(registry);
	}*/

}
