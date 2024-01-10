package restassured.learning;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaValidation {

    @Test
    public void getPostSchemaValidation() {
        when()
                .get("https://jsonplaceholder.typicode.com/posts/{id}", 2)
        .then()
                .assertThat().body(matchesJsonSchemaInClasspath("postSchema.json"));
    }
}
