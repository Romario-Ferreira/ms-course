package com.francaemp.hrworker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francaemp.hrworker.entities.Worker;
import com.francaemp.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository repository;

	public List<Worker> findAll() {
		return repository.findAll();
	}

	public Worker findById(Long id) {
		Worker obj = repository.findById(id).get();
		return obj;
	}
	
}
