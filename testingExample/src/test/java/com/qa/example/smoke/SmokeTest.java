package com.qa.example.smoke;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.example.controller.SimpleController;
import com.qa.example.repository.SimpleRepository;
import com.qa.example.service.SimpleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {
	
	/*Smoke tests are S U P E R basic, they only really test that the project configuration is set up correctly
		They see if an autowired component has been correctly instantiated by the IoC
		They do not test functionality
*/
	@Autowired
	private SimpleController simpleController;
	@Autowired
	private SimpleRepository simpleRepository;
	@Autowired
	private SimpleService simpleService;
	
	@Test
	public void controllerSmokeTest() {
		assertThat(simpleController).isNotNull();
	}
	@Test
	public void repositorySmokeTest() {
		assertThat(simpleRepository).isNotNull();
	}
	
	@Test
	public void serviceSmokeTest() {
		assertThat(simpleService).isNotNull();
	}
	
	
	
}
