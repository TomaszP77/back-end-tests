package restassured.learning;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void filterPostsById() {
        given()
                .log().all()
                .queryParam("id", 1, 5, 10)
        .when()
                .get("https://jsonplaceholder.typicode.com/posts/")
        .then()
                .log().all();
    }

    @Test
    public void filterPostsByIdTitle() {
        Map<String, Object> params = new HashMap<>();
        params.put("id", "5");
        params.put("title", "nesciunt quas odio");

        given()
                .log().all()
                .queryParams(params)
        .when()
                .get("https://jsonplaceholder.typicode.com/posts/")
        .then()
                .log().all();
    }
}
