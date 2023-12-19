package restassured.learning;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class FilterPosts {

    @Test
    public void filterPostsByTitle() {
        given()
                .log().all()
                .queryParam("title", "optio molestias id quia eum")
        .when()
                .get("https://jsonplaceholder.typicode.com/posts/")
        .then()
                .log().all();
    }
}
