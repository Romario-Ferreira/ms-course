package com.francaemp.hrworker.controllers;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francaemp.hrworker.entities.Worker;
import com.francaemp.hrworker.repositories.WorkerRepository;
import com.francaemp.hrworker.services.WorkerService;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerRepository.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerService service;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		
		/*try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		logger.info("PORT =" + env.getProperty("local.server.port"));
		
		return ResponseEntity.ok().body(service.findById(id));
	}

}
