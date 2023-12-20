package restassured.learning;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class CheckingTheStatusCode {

    @Test
    public void getPosts(){
        when()
                .get("https://jsonplaceholder.typicode.com/posts/")
        .then()
                .log().all()
                .statusCode(200);
    }

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
                .log().all()
                .statusCode(201);
    }
}
