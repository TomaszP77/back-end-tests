package jsonplaceholder.tests;

import jsonplaceholder.tests.framework.BaseTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class DeletePost extends BaseTest {

    @Test
    public void deletePost(){
        given()
                .spec(reqSpec)
                .pathParam("id",1)
        .when()
                .delete("{id}")
        .then()
                .spec(respSpec);
    }
}
