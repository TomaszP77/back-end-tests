package restassured.learning;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import restassured.learning.model.Post;

import static io.restassured.RestAssured.given;

public class AddPostObject {

    @Test
    public void addPostObject() {
        Post newPost = new Post();
        newPost.setUserId(777);
        newPost.setTitle("new post");
        newPost.setBody("new post from object");

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

