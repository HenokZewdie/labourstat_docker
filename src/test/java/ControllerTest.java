import com.restapi.laborstats.EmployeeController;
import com.restapi.laborstats.EmployeeValidator;
import com.restapi.laborstats.LaborStatService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = EmployeeController.class)
@Import(EmployeeValidator.class)
//@SpringBootTest
@ContextConfiguration(classes = EmployeeController.class)
public class ControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    LaborStatService laborStatService;

    @Autowired
    EmployeeValidator employeeValidator;
    @Test
    public void testController() throws Exception {
        this.mockMvc
                .perform(
                        get("http://localhost:8080/rest/allEmployees")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testControllerGetAll() throws Exception {
        this.mockMvc
                .perform(
                        get("http://localhost:8080/rest/getOneEmployees/1")
                                .param("firstName", "Value")
                                .param("lastName", "Value")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    @Test
    public void ensureBadRequestIsThrownWhenThereIsNoFirstName() throws Exception {
        this.mockMvc
                .perform(
                        get("http://localhost:8080/rest/getOneEmployees/1")
                                .param("lastName", "Value")
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
