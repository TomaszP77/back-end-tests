import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BaseTest {

    private RequestSpecification reqSpec;
    private ResponseSpecification respSpec;

    @BeforeEach
    public void setUp() {

        reqSpec = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com/")
                .setBasePath("posts")
                .setContentType(ContentType.JSON)
                .build();

        respSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        RequestLoggingFilter reqLog = new RequestLoggingFilter();
        ResponseLoggingFilter respLog = new ResponseLoggingFilter();
        RestAssured.filters(reqLog, respLog);
    }

    @Test
    public void test() {
        given()
                .spec(reqSpec)
        .when()
                .get()
        .then()
                .spec(respSpec);
    }
}
