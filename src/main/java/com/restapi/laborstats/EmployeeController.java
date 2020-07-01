package com.restapi.laborstats;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
@Api(value = "Employee Resource", description = "This is the description about the APIs")
public class EmployeeController {

    @Autowired
    private EmployeeValidator employeeValidator;
    private final Logger LOGGER= LoggerFactory.getLogger(this.getClass().getName());
    LaborStatService laborStatService = new LaborStatService();
    private String id;

    @ApiOperation(value = "Persist and show All the Employees")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 100, message = "100 is the message"),
                    @ApiResponse(code = 200, message = "Successful Hello World")
            }
    )
    @RequestMapping(value = "/allEmployees", method = RequestMethod.POST)
    public EmployeeResponse allEmployeesMethod() {
        LOGGER.info("Enter into the Controller");
        EmployeeResponse employeeResponse = laborStatService.employeeResponse();
        return employeeResponse;
    }

    @ApiOperation(value = "A single Employee")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 100, message = "100 is the message"),
                    @ApiResponse(code = 200, message = "Successful Hello World")
            }
    )
    @RequestMapping(value = "/getOneEmployees/{id}", method = RequestMethod.GET)
    public ResponseEntity<EmployeeResponse> getAllEmployeesMethod(
            @PathVariable("id") String id,
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "lastName", required = false) String lastName
    ) {
        LOGGER.info("Enter into the GET Controller");
        employeeValidator.validateTheEmployeeRequest(id, firstName, lastName);
        EmployeeResponse employeeResponse = laborStatService.employeeResponse();
        return ResponseEntity.ok(employeeResponse);
    }
}
