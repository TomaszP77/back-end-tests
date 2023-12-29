package restassured.learning;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class VerifyResponse {

    @Test
    public void verifyResponse() {
        String expected = "{\n" +
                "  \"userId\": 1,\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"delectus aut autem\",\n" +
                "  \"completed\": false\n" +
                "}";

        given()
                .log().all()
        .when()
                .get("https://jsonplaceholder.typicode.com/todos/{id}",1)
        .then()
                .log().all()
                .body(equalTo(expected));
    }

    @Test
    public void verifyResponseContainsString() {
        given()
                .log().all()
        .when()
                .get("https://jsonplaceholder.typicode.com/todos/{id}",1)
        .then()
                .log().all()
                .body(Matchers.containsString("delectus aut autem"));
    }

    @Test
    public void verifyResponseContainsStringIgnoringCase() {
        given()
                .log().all()
        .when()
                .get("https://jsonplaceholder.typicode.com/todos/{id}",1)
        .then()
                .log().all()
                .body(Matchers.containsStringIgnoringCase("DELECTUS AUT AUTEM"));
    }

    @Test
    public void verifyResponseCheckSpecificField() {
        given()
                .log().all()
        .when()
                .get("https://jsonplaceholder.typicode.com/todos/{id}", 1)
        .then()
                .log().all()
                .assertThat().body("title", equalTo("delectus aut autem"))
                .assertThat().body("completed", equalTo(false));
    }
}
