package com.francaemp.hroauth.services;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francaemp.hroauth.entities.User;
import com.francaemp.hroauth.feignclients.UserFeignClient;


@Service
public class UserService {

	private static Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		if (user == null) {
			log.error("Email not found" + email);
			throw new IllegalArgumentException("Email not found");
		}
		log.info("email found: " + email);
		return user;
	}
}
