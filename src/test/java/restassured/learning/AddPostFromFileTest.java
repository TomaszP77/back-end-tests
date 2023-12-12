package restassured.learning;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class AddPostFromFileTest {

    @Test
    public void addPostFromFile() {
        File newPost = new File("src/test/resources/post.json");

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
