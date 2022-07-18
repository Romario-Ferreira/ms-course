package com.francaemp.hrpayroll.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francaemp.hrpayroll.entities.Payment;
import com.francaemp.hrpayroll.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@GetMapping(value = "/{id}/days/{days}")
	public ResponseEntity<Payment> getPayment (@PathVariable long id,
											   @PathVariable int days){
		
		return ResponseEntity.ok().body(service.getPayment(id, days));
	}
}
