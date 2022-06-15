package com.miniappservice2.controller;

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
	
	@GetMapping
	public String getData() {
		System.out.println("------  CLIENT-SERVICE-2 - SECONDCLIENTCONTROLLER -  GETDATA  ------------------");
		return "CLIENT-SERVICE-2 IS UP !!!";
	}
	
	@GetMapping("/from-others")
	public String getInfoFromOthers() {
		System.out.println("------  CLIENT-SERVICE-2 - SECONDCLIENTCONTROLLER -  getInfoFromOthers  ------------------");
		return restTemplate.getForObject("http://client-service-1/client-service-1/for-others", String.class);
	}
	
	@GetMapping("/for-others")
	public String getInfoForOthers() {
		System.out.println("------  CLIENT-SERVICE-2 - SECONDCLIENTCONTROLLER -  getInfoForOthers  ------------------");
		return "CLIENT-SERVICE-2 IS INVOKED !!!";
	}
}
