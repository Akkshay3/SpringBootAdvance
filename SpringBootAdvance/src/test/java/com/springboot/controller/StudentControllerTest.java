package com.springboot.controller;



import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.springboot.config.StudentConfig;
import com.springboot.controller.StudentController;

@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
@ContextConfiguration("StudentConfig")

public class StudentControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void testGetAllStudent() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders.get("/student/all")
													   .accept(MediaType.APPLICATION_JSON).header("student-auth-key", "");
		
		MvcResult result = mockMvc.perform(request)
								  .andExpect(status().isOk())
								  .andExpect(content().json("[{\"name\":\"Xyz\",\"city\":\"Pune\",\"contactNo\":\"8912346710\",\"emailId\":\"xyz@mail.com\",\"roll_no\":1},{\"name\":\"ABC\",\"city\":\"Mumbai\",\"contactNo\":\"9988776655\",\"emailId\":\"abc@hotmail.com\",\"roll_no\":2},{\"name\":\"PQR\",\"city\":\"Bangalore\",\"contactNo\":\"8710462300\",\"emailId\":\"pqr@outlook.com\",\"roll_no\":3}]"))
								  .andReturn();
		//assertEquals(expected, actual);
	}
}
