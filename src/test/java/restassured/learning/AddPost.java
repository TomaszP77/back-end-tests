package restassured.learning;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class AddPost {

    @Test
    public void addPost() {
        String newPost = "{\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 10,\n" +
                "    \"title\": \"optio molestias id quia eum\",\n" +
                "    \"body\": \"new post\"}";

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
