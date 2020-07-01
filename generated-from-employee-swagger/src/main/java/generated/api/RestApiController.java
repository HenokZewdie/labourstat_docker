package generated.api;

import generated.api.model.EmployeeResponse;

import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-07-01T15:30:15.924-04:00")

@Controller
public class RestApiController implements RestApi {



    public ResponseEntity<EmployeeResponse> allEmployeesMethodUsingPOST() {
        // do some magic!
        return new ResponseEntity<EmployeeResponse>(HttpStatus.OK);
    }

    public ResponseEntity<EmployeeResponse> getAllEmployeesMethodUsingGET(@ApiParam(value = "This is the employee Id",required=true ) @PathVariable("id") String id,
         @NotNull@ApiParam(value = "First name of the employee", required = true) @RequestParam(value = "firstName", required = true) String firstName,
        @ApiParam(value = "lastName") @RequestParam(value = "lastName", required = false) String lastName) {
        // do some magic!
        return new ResponseEntity<EmployeeResponse>(HttpStatus.OK);
    }

}
