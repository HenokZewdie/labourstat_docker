import com.google.gson.Gson;
import com.restapi.laborstats.EmployeeResponse;
import com.restapi.laborstats.LaborStatService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ServiceTest {

    @Mock
    RestTemplate restTemplate;

    @Test
    public void serviceTest() {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        LaborStatService laborStatService = new LaborStatService();
        BDDMockito.given(restTemplate.exchange(BDDMockito.anyString(), Mockito.eq(HttpMethod.GET), BDDMockito.any(),
                Mockito.eq(String.class))).willReturn(buildResponse());
        employeeResponse = laborStatService.employeeResponse();
        Assert.assertNotNull(employeeResponse);
    }

    private ResponseEntity<String> buildResponse() {
        Gson gson = new Gson();
        String response = "{\"status\": \"success\",\"data\": [{\"id\": \"1\",\"employee_name\": \"Tiger Nixon\",\"employee_salary\": \"320800\",\"employee_age\": \"61\",\"profile_image\": \"\"},{\"id\": \"2\",\"employee_name\": \"Garrett Winters\",\"employee_salary\": \"170750\",\"employee_age\": \"63\",\"profile_image\": \"\"}]}";
        ResponseEntity<String> responseEntity = new ResponseEntity<String>(response, new HttpHeaders(), HttpStatus.OK);
        response = responseEntity.getBody();
        EmployeeResponse employeeResponse = gson.fromJson(response, EmployeeResponse.class);
        System.out.println(employeeResponse);
        return responseEntity;
    }

}
