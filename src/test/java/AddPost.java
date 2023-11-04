import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AddPost extends BaseTest {

    @Test
    public void addPost() {

        model.Post post = new model.Post(7, "POST", "Test POST");

        model.Post createdPost = given()
                                    .spec(reqSpec)
                                    .body(post)
                                .when()
                                    .post()
                                .then()
                                    .statusCode(201)
                                    .contentType(ContentType.JSON)
                                    .extract().body().as(model.Post.class);

        Assertions.assertEquals(post, createdPost);
    }
}
