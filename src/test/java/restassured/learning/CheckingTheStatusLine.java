package restassured.learning;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void addPostMap() {
        Map<String, Object> newPost = new HashMap<>();
        newPost.put("userId", 67);
        newPost.put("title", "new post");
        newPost.put("body", "new post from map");

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(newPost)
        .when()
                .post("https://jsonplaceholder.typicode.com/posts/")
        .then()
                .log().all()
                .statusLine(Matchers.containsString("201 Created"));
    }
}
