import com.restapi.laborstats.BadRequestException;
import com.restapi.laborstats.EmployeeControllerAdvice;
import com.restapi.laborstats.Error;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class EmployeeControllerAdviceTest {

    public static final String EXCEPTION = "exception";
    private EmployeeControllerAdvice employeeControllerAdvice;

    @Before
    public void setup(){
        employeeControllerAdvice = new EmployeeControllerAdvice();
    }

    @Test
    public void ensureBadRequestExceptionWithMessageIsHandled(){
        ResponseEntity<Error> responseEntity =
                employeeControllerAdvice.handleBadRequestException(new BadRequestException(EXCEPTION));
        assertErrorResponses(responseEntity, BAD_REQUEST, EMPTY);
    }

    private void assertErrorResponses(ResponseEntity<Error> responseEntity, HttpStatus httpStatus, String errorCode) {
        assertErrorResponses(responseEntity, httpStatus, errorCode, EXCEPTION);
    }

    private void assertErrorResponses(ResponseEntity<Error> responseEntity, HttpStatus httpStatus,
                                      String errorCode, String description) {
        assertThat(responseEntity.getStatusCode(), is(httpStatus));
        assertThat(Objects.requireNonNull(responseEntity.getBody()).getError().getCode(), is(errorCode));
        assertThat(responseEntity.getBody().getError().getDescription(), is(description));
    }
}
