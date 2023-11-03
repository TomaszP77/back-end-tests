import model.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PatchPostTest extends BaseTest {

    @Test
    public void patchPost() {

        Post post = new Post("Updated POST");

        Post createdPost = given()
                                .spec(reqSpec)
                                .pathParam("id", 1)
                                .body(post)
                            .when()
                                .patch("{id}")
                            .then()
                                .spec(respSpec)
                                .extract().body().as(Post.class);

        Assertions.assertEquals("Updated POST", createdPost.getTitle());
        Assertions.assertEquals("qui est esse",createdPost.getBody());
    }
}
