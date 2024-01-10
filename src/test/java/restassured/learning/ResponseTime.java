package restassured.learning;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.when;

public class ResponseTime {

    @Test
    public void getPost() {
        when()
                .get("https://jsonplaceholder.typicode.com/posts").
        then()
                .time(Matchers.lessThan(1000L), TimeUnit.MILLISECONDS);
    }
}
