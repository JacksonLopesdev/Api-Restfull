package app.car.interfaces.incoming;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PassengerAPITestIT {

    @LocalServerPort
    private int port;

    @BeforeEach
    public void setup() {
        RestAssured.port = port;
    }

    @Test
    public void testCreatePassenger(){
        String createPassengerJSON = "{\"name\":\"Jackson Lopes\"}";

            given()
                    .contentType(ContentType.JSON)
                    .body(createPassengerJSON)
                    .post("/passengers")
                    .then()
                    .statusCode(200)
                    .body("id", notNullValue())
                    .body("name", equalTo("Jackson Lopes"));
    }
}
