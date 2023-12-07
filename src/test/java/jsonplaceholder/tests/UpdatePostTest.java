package jsonplaceholder.tests;

import jsonplaceholder.tests.framework.BaseTest;
import jsonplaceholder.tests.model.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UpdatePostTest extends BaseTest {

    @Test
    public void updatePost() {

        Post post = new Post(7, "POST", "Test POST");

        Post createdPost = given()
                                .spec(reqSpec)
                                .pathParam("id", 3)
                                .body(post)
                            .when()
                                .put("{id}")
                            .then()
                                .spec(respSpec)
                                .extract().body().as(Post.class);

        Assertions.assertEquals(post, createdPost);
    }
}
