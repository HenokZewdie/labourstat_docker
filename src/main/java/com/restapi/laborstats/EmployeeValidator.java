package com.restapi.laborstats;

import com.google.common.base.Strings;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator {

    public void validateTheEmployeeRequest(String id, String fName, String lName){
        validateEmployeeId(id);
        validateEmployeeFirstName(fName);
        validateEmployeeLastName(lName);
    }

    private void validateEmployeeId(String id) {
        if(StringUtils.isEmpty(id)){
            throw new BadRequestException(EmployeeError.INVALID_ID);
        }
    }

    private void validateEmployeeLastName(String lName) {
        if(lName.trim().isEmpty()){
            throw new BadRequestException(EmployeeError.INVALID_LAST_NAME);
        }
    }

    private void validateEmployeeFirstName(String fName) {
        if(Strings.isNullOrEmpty(fName)){
            throw new BadRequestException(EmployeeError.INVALID_FIRST_NAME);
        }
    }

    public void validateTheEmployeeRequestVarArgs(String... args){

    }
}
