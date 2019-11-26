package com.qa.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.example.entity.SimpleEntity;
import com.qa.example.repository.SimpleRepository;

@Service
public class SimpleService {
	@Autowired
	private SimpleRepository simpleRepository;
	
	public String sayHello() {
		return "Hello!";
	}
	
	public List<SimpleEntity> getAllEntities(){
		return simpleRepository.findAll();
	}
	
	public SimpleEntity findEntityByID(Long id) {
		return simpleRepository.getOne(id);
	}
	
	public SimpleEntity insertOneValidEntity(SimpleEntity entity) {
		return simpleRepository.save(entity);
	}

}
