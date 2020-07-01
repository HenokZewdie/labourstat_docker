package com.restapi.laborstats;
import static org.apache.commons.lang3.StringUtils.EMPTY;
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = -1217744922734141704L;

    private final EmployeeError employeeError;

    public BadRequestException(String message) {
        super(message);
        this.employeeError = null;
    }

    public BadRequestException(EmployeeError employeeError) {
        super(employeeError.getDescription());
        this.employeeError = employeeError;
    }
    public String errorCode(){
        return (employeeError == null)? EMPTY : employeeError.getCode();
    }
}
