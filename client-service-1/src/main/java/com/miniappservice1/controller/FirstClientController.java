package com.miniappservice1.controller;

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
	
	@GetMapping
	public String getData() {
		System.out.println("------  CLIENT-SERVICE-1 - FIRSTCLIENTCONTROLLER -  GETDATA  ------------------");
		return "CLIENT-SERVICE-1 IS UP !!!";
		
	}
	
	@GetMapping("/from-others")
	public String getInfoFromOthers() {
		System.out.println("------  CLIENT-SERVICE-1 - FIRSTCLIENTCONTROLLER -  getInfoFromOthers  ------------------");
		return restTemplate.getForObject("http://client-service-2/client-service-2/for-others", String.class);
	}
	
	@GetMapping("/for-others")
	public String getInfoForOthers() {
		System.out.println("------  CLIENT-SERVICE-1 - FIRSTCLIENTCONTROLLER -  getInfoForOthers  ------------------");
		return "CLIENT-SERVICE-1 IS INVOKED !!!";
	}

}
