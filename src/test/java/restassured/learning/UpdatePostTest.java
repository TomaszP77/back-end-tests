package restassured.learning;

import io.restassured.http.ContentType;
import jsonplaceholder.tests.model.Post;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdatePostTest {

    @Test
    public void updatePostObject() {
        Post newPost = new Post();
        newPost.setTitle("title after update object");

        given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(newPost)
        .when()
                .patch("https://jsonplaceholder.typicode.com/posts/10")
        .then()
                .log().all();
    }
}
