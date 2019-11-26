package com.qa.example.integration;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.qa.example.controller.SimpleController;
import com.qa.example.entity.SimpleEntity;
import com.qa.example.service.SimpleService;

//Integration tests are to test the connections between multiple components
//in this test, we are seeing if the controller and service connect up together
//The test performs a pretend web request to the mapping we specify
//and using mocking, we see that the correct components are hit and are working
//as expected.

@RunWith(SpringRunner.class)

//The subject of the test
@WebMvcTest(SimpleController.class)

//Spring doing the config for us
@AutoConfigureMockMvc
public class WebMockTest {
	
	
	//this will perform the pretend web request
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private SimpleService simpleService;
	
	
	private static final SimpleEntity mockEntity1 = new SimpleEntity("Dale", 1L);
	private static final SimpleEntity mockEntity2 = new SimpleEntity("Ian", 2L);

	@Test
	public void getAllTest() throws Exception {
		
		//we save some prebuilt entities in an array
		List<SimpleEntity> mockEntities = new ArrayList<>();
		mockEntities.add(mockEntity1);
		mockEntities.add(mockEntity2);
		
		
		//mock the getALLEntities method to return our array of prebuilds
		when(simpleService.getAllEntities()).thenReturn(mockEntities);
		
		
		//perform the get request and (in order) expect it to return status code 200
		//expect the content to be of type JSON
		//expect the name of the first item in the JSON array to be 'Dale'
		//expect the name of the second item in the JSON array to be 'Ian'
		//JSON paths can be tricky, so go to http://jsonpathfinder.com/ if you get stuck
		mockMvc.perform(get("/simple/all")).andExpect(status().isOk())
		   .andExpect(content().contentType(MediaType.APPLICATION_JSON))
		   .andExpect(jsonPath("[0].name").value("Dale"))
		   .andExpect(jsonPath("[1].name").value("Ian"));
		 
	}
}
