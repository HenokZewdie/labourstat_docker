package com.restapi.laborstats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@RestController
public class EmployeeController {
	
	@Autowired 	private RestTemplate restTemplate;
	private ObjectMapper objectMapper;
	Gson gson = new Gson();
	@RequestMapping(value="/allEmployees",method=RequestMethod.GET)
	public EmployeeResponse allEmployeesMethod() {
		
		EmployeeResponse employeeResponse= new EmployeeResponse();
		HttpHeaders headers = new HttpHeaders();
		String url = "http://dummy.restapiexample.com/api/v1/employees";
		HttpEntity<?> entity = new HttpEntity<>(headers);
		ResponseEntity<String> responseEntity = null;
		String response = null;
		
		try {
			responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
			response = responseEntity.getBody();
			employeeResponse = gson.fromJson(response, EmployeeResponse.class);	
			}catch(Exception e) {
			System.out.println("#######" + e.getMessage());
		}
		
		return employeeResponse;
	}
	
	
}
