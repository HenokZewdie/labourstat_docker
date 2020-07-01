package com.restapi.laborstats;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LaborStatService {
    private final Logger LOGGER= LoggerFactory.getLogger(this.getClass().getName());
    RestTemplate restTemplate = new RestTemplate();
    Gson gson = new Gson();
    public EmployeeResponse employeeResponse(){
        EmployeeResponse employeeResponse = new EmployeeResponse();
        HttpHeaders headers = new HttpHeaders();
        String url = "http://dummy.restapiexample.com/api/v1/employees";
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity;
        String response = null;

        try {
            LOGGER.info("Enter into try");
            responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            response = responseEntity.getBody();
            employeeResponse = gson.fromJson(response, EmployeeResponse.class);
            LOGGER.info("Get the response {}", employeeResponse);
        } catch (Exception e) {
            System.out.println("#######" + e.getMessage());
        }
        return employeeResponse;
    }
}
