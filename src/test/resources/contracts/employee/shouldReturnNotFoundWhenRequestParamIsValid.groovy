package contracts.employee

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method('GET')
        urlPath("/rest/getOneEmployees//"){
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
        status(404)
    }
}