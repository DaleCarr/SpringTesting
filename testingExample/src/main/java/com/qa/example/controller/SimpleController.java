package com.qa.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.example.entity.SimpleEntity;
import com.qa.example.service.SimpleService;

@RestController
@RequestMapping("/simple")
public class SimpleController {
	
	@Autowired
	private SimpleService simpleService;
	
	
	@GetMapping("/hello")
	public ResponseEntity<String> getSimpleHello(){
		return ResponseEntity.ok(simpleService.sayHello());
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<SimpleEntity>> getAllSimpleEntities(){
		return ResponseEntity.ok(simpleService.getAllEntities());
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<SimpleEntity> saveSimpleEntity(@RequestBody SimpleEntity entity){
		return ResponseEntity.ok(simpleService.insertOneValidEntity(entity));
	}

}
