package restassured.learning;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

public class GetPost {

    @Test
    public void getPost(){
        when().get("jsonplaceholder.typicode.com/posts/1").then().log().all();
    }
}
