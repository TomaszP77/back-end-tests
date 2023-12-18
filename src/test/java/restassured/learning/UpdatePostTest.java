package restassured.learning;

import io.restassured.http.ContentType;
import jsonplaceholder.tests.model.Post;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UpdatePostTest {

    @Test
    public void updatePost() {
        Map<String, Object> newPost = new HashMap<>();
        newPost.put("userId", 66);
        newPost.put("title", "title after update");
        newPost.put("body", "body after update");

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
    public void updatePostObject() {
        Post newPost = new Post();
        newPost.setUserId(23);
        newPost.setTitle("title after update object");
        newPost.setBody("body after update object");

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

