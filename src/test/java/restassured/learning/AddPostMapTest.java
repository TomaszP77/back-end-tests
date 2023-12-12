package restassured.learning;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AddPostMapTest {

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
                .log().all();
    }
}
