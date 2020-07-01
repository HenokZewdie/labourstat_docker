import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.apache.http.HttpHeaders.CONTENT_TYPE;
import static org.apache.http.entity.ContentType.APPLICATION_JSON;

//@RunWith(SpringRunner.class)
public class ComponentTest {

  // @Test
    public void testWireMock(){
        stubFor(
                get(urlEqualTo("/wiremock/employsdgdfgees"))
                .willReturn(
                        aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader(CONTENT_TYPE, String.valueOf(APPLICATION_JSON))
                        .withBodyFile("mock/StubEmployeeInformation.json")));
    }
}
