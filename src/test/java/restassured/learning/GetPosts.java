package restassured.learning;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

public class GetPosts {

    @Test
    public void getPosts(){
        when()
                .get("https://jsonplaceholder.typicode.com/posts/")
        .then()
                .log().all();
    }
}
