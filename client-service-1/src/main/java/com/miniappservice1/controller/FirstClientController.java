package com.miniappservice1.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client-service-1")
public class FirstClientController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Logger logger;
	
	@GetMapping
	public String getData() {
		logger.info("------  FIRSTCLIENTCONTROLLER -  GETDATA  ------------------");
		return "CLIENT-SERVICE-1 IS UP !!!";
		
	}
	
	@GetMapping("/from-others")
	public String getInfoFromOthers() {
		logger.info("------  FIRSTCLIENTCONTROLLER -  getInfoFromOthers  ------------------");
		return restTemplate.getForObject("http://client-service-2/client-service-2/for-others", String.class);
	}
	
	@GetMapping("/for-others")
	public String getInfoForOthers() {
		logger.info("------  FIRSTCLIENTCONTROLLER -  getInfoForOthers  ------------------");
		return "CLIENT-SERVICE-1 IS INVOKED !!!";
	}

}
