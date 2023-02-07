package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DataReaderController {

	private static final Logger log = LoggerFactory.getLogger(DataReaderController.class);

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/collect")
	public @ResponseBody String getAPIData() {

		final String API_ENDPOINT = "https://finances.worldbank.org/resource/ebmi-69yj.json?end_of_period=2022-12-31T00:00:00.000";
		// API_ENDPOINT =
		// "https://finances.worldbank.org/resource/ebmi-69yj.json?end_of_period=2022-12-31T00:00:00.000";

		List<Map<String, String>> response = restTemplate.getForObject(API_ENDPOINT, List.class);
		log.info(response + "");

		return response == null ? "Data is not received" : "Data Layout : " + response.get(0).keySet();

	}

}
