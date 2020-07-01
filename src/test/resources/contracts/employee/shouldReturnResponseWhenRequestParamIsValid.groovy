package contracts.employee

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method('GET')
        urlPath("/rest/getOneEmployees/1"){
            queryParameters {
                parameter("firstName", "Mena")
                parameter("lastName", "Eliana")
            }
        }
        headers {
            header('Content-Type', 'application/json')
        }
    }

    response {
        status(200)
        body("""
{
    "status": "success",
    "data": [
        {
            "id": "1",
            "employee_name": "Tiger Nixon",
            "employee_salary": "320800",
            "employee_age": "61",
            "profile_image": ""
        },
        {
            "id": "2",
            "employee_name": "Garrett Winters",
            "employee_salary": "170750",
            "employee_age": "63",
            "profile_image": ""
        },
        {
            "id": "3",
            "employee_name": "Ashton Cox",
            "employee_salary": "86000",
            "employee_age": "66",
            "profile_image": ""
        }
    ]
}
""")
    }
}