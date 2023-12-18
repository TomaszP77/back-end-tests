package restassured.learning;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

public class DeletePost {

    @Test
    public void deletePost() {
        when()
                .delete("https://jsonplaceholder.typicode.com/posts/10")
        .then()
                .log().all();
    }
}
