package com.qa.example.mocking;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.example.controller.SimpleController;
import com.qa.example.entity.SimpleEntity;
import com.qa.example.service.SimpleService;

@RunWith(SpringRunner.class)
public class ControllerMockTest {

	//Our test subject, the component we wish to test
@InjectMocks
SimpleController simpleController;

//	The components our test subject needs in order to run. In this case, there has to be a 
//	simpleService running as the controller calls those methods. Thankfully, we only need to 
//	go one layer deep, so we don't need to mock the repository
@Mock
SimpleService simpleService;


@Test
public void controllerHelloTest() {
	//the first thing we do is create the mock methods for the service.
	//the mock is a pretend version of the component we're mocking
	//In this line we say, "WHen the sayHello method is called, instead of using the real verion,
	//instead, just return "Hello!""
	Mockito.when(simpleService.sayHello()).thenReturn("Hello!");
	assertEquals(simpleController.getSimpleHello().getBody(), "Hello!");
}

}
