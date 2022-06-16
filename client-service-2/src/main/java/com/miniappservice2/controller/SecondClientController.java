package com.miniappservice2.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client-service-2")
public class SecondClientController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Logger logger;
	
	@GetMapping
	public String getData() {
		logger.info ("------  SECONDCLIENTCONTROLLER -  GETDATA  ------------------");
		return "CLIENT-SERVICE-2 IS UP !!!";
	}
	
	@GetMapping("/from-others")
	public String getInfoFromOthers() {
		logger.info("------  SECONDCLIENTCONTROLLER -  getInfoFromOthers  ------------------");
		return restTemplate.getForObject("http://client-service-1/client-service-1/for-others", String.class);
	}
	
	@GetMapping("/for-others")
	public String getInfoForOthers() {
		logger.info("------  SECONDCLIENTCONTROLLER -  getInfoForOthers  ------------------");
		return "CLIENT-SERVICE-2 IS INVOKED !!!";
	}
}
