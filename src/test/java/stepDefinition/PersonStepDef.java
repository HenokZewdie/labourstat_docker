package stepDefinition;

import com.restapi.laborstats.EmployeeController;
import com.restapi.laborstats.EmployeeInfo;
import com.restapi.laborstats.EmployeeResponse;
import com.restapi.laborstats.LaborStatService;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonStepDef {

    EmployeeController employeeController;
    EmployeeResponse employeeResponse;
    @Autowired
    LaborStatService laborStatService;

    @Given("^an employee works here$")
    public void anEmployeeWorksHere(DataTable dataTable) throws IOException {
        employeeController = new EmployeeController();
    }


    @When("^the api is invoked$")
    public void theApiIsInvoked() {
        employeeResponse = employeeController.allEmployeesMethod();
        System.out.println(employeeResponse);
    }

    @Then("^the response code is \"([^\"]*)\"$")
    public void theResponseCodeIs(int arg0) {

    }

    @And("^an employee with \"([^\"]*)\" with \"([^\"]*)\"$")
    public void anEmployeeWithWith(String id, String salary) {
        assertTrue(employeeResponse.getData().stream()
                .anyMatch(a -> id.equalsIgnoreCase(a.getId())
                        && salary.equalsIgnoreCase(a.getEmployee_salary())));
        Optional<Integer> result = employeeResponse.getData().stream()
                .map(EmployeeInfo::getEmployee_salary)
                .collect(Collectors.toList())
                .stream().map(Integer::parseInt)
                .collect(Collectors.toList())
                .stream().max(Integer::compare);
        result.ifPresent(integer -> assertEquals(Integer.valueOf(725000), integer));
    }

    @And("^with \"([^\"]*)\" with \"([^\"]*)\"$")
    public void withWith(String firstName, String lastName) {
        employeeResponse.getData().stream()
                .forEach(a->System.out.println(a.getEmployee_name().toUpperCase()));

        assertTrue(employeeResponse.getData().stream().anyMatch(
                names->names.getEmployee_name().equalsIgnoreCase(
                        firstName.concat(" ").concat(lastName)
                )
        ));

    }

    @And("^\"([^\"]*)\" years old$")
    public void yearsOld(String age) {
        assertTrue(employeeResponse.getData().stream()
                .anyMatch(a -> age.equalsIgnoreCase(a.getEmployee_age())));
    }

    @And("^employee \"([^\"]*)\"$")
    public void employee(String name) {
    }

    @And("^returned value is \"([^\"]*)\"$")
    public void returnedValueIs(String arg0) {
    }
}
