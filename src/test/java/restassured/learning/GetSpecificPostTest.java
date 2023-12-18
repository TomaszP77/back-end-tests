package restassured.learning;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetSpecificPostTest {

    @Test
    public void getPostPathParam() {
        given()
                .log().all()
                .pathParam("id", 11)
        .when()
                .get("https://jsonplaceholder.typicode.com/posts/{id}")
        .then()
                .log().all();
    }

    @Test
    public void getPost() {
        given()
                .log().all()
        .when()
                .get("https://jsonplaceholder.typicode.com/posts/{id}", 11)
        .then()
                .log().all();
    }
}
