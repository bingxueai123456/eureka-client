package com.ice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: eclair
 * @Description:
 * @Date: 2019/7/26
 */
@RestController
public class ClientController {
	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/api/json/ribbon/call/{key}")
	public String callProducerByRibbo(@PathVariable("key") String key) {
		return restTemplate.getForObject("http://EUREKA-PRODUCER/api/json/test/get/args?key=" + key, String.class);
	}
}
