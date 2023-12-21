package restassured.learning;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CheckingTheStatusLine {

    @Test
    public void getPostPathParam() {
        given()
                .log().all()
                .pathParam("id", 11)
        .when()
                .get("https://jsonplaceholder.typicode.com/posts/{id}")
        .then()
                .log().all()
                .statusLine("HTTP/1.1 200 OK");
    }
}
