package com.qa.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.example.entity.SimpleEntity;


public interface SimpleRepository extends JpaRepository<SimpleEntity,Long> {

}
