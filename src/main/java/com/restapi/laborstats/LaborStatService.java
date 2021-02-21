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

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Service
public class LaborStatService {
    private final Logger LOGGER= LoggerFactory.getLogger(this.getClass().getName());
    RestTemplate restTemplate = new RestTemplate();
    Gson gson = new Gson();
    public com.restapi.laborstats.EmployeeResponse employeeResponse(){
        EmployeeResponse employeeResponse = new EmployeeResponse();
        HttpHeaders headers = new HttpHeaders();
        String url = "http://dummy.restapiexample.com/api/v1/employees";
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity;
        String response = null;

        try {
            LOGGER.info("Enter into try");
            responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            LOGGER.info("Get the response {}", employeeResponse);
            response = responseEntity.getBody();
            employeeResponse = gson.fromJson(response, EmployeeResponse.class);
            LOGGER.info("Get the response {}", employeeResponse);
        } catch (Exception e) {
            System.out.println("#######" + e.getMessage());
        }
        return employeeResponse;
    }
    public GeoPlugin xmlResponse() throws JAXBException {
        HttpHeaders headers = new HttpHeaders();
        String url = "http://www.geoplugin.net/xml.gp?ip=72.191.37.61";
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity;
        String response = null;

        try {
            LOGGER.info("Enter into try");
            responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            response = responseEntity.getBody();
        } catch (Exception e) {
            System.out.println("#######" + e.getMessage());
        }
        JAXBContext jaxbContext;
        jaxbContext = JAXBContext.newInstance(GeoPlugin.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        GeoPlugin employee = (GeoPlugin) jaxbUnmarshaller.unmarshal(new StringReader(response));
        return employee;
    }
}
