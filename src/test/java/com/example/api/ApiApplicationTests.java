package com.example.api;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.api.domain.Customer;
import com.example.api.web.rest.CustomerController;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ApiApplicationTests {
	
	@Autowired
	private CustomerController controller;

	@Test
	public void findByIdTest() {
		
		Customer customer = controller.findById(1L);
		
		assertEquals("Mariazinha", customer.getName());
		assertEquals("mariazinha@email.com", customer.getEmail());
		
	}

}
