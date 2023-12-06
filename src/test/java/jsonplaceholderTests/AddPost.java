package jsonplaceholderTests;

import io.restassured.http.ContentType;
import jsonplaceholderTests.model.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AddPost extends BaseTest {

    @Test
    public void addPost() {

        Post post = new Post(7, "POST", "Test POST");

        Post createdPost = given()
                                .spec(reqSpec)
                                .body(post)
                           .when()
                                .post()
                           .then()
                                .statusCode(201)
                                .contentType(ContentType.JSON)
                                .extract().body().as(jsonplaceholderTests.model.Post.class);

        Assertions.assertEquals(post, createdPost);
    }
}
