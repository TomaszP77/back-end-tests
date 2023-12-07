package restassured.learning;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

public class GetPost {

    @Test
    public void getPost() {
        when()
                .get("https://jsonplaceholder.typicode.com/posts/10")
        .then()
                .log()
                .all();
    }
}
