package restassured.learning;

import io.restassured.http.ContentType;
import jsonplaceholder.tests.model.Post;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ReplacePostTest {

    @Test
    public void replacePost() {
        Map<String, Object> newPost = new HashMap<>();
        newPost.put("userId", 66);
        newPost.put("title", "title after replace");
        newPost.put("body", "body after replace");

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(newPost)
        .when()
                .put("https://jsonplaceholder.typicode.com/posts/10")
        .then()
                .log().all();
    }

    @Test
    public void replacePostObject() {
        Post newPost = new Post();
        newPost.setUserId(23);
        newPost.setTitle("title after replace object");
        newPost.setBody("body after replace object");

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(newPost)
        .when()
                .put("https://jsonplaceholder.typicode.com/posts/10")
        .then()
                .log().all();
    }
}

