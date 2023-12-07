package jsonplaceholder.tests;

import jsonplaceholder.tests.framework.BaseTest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetPosts extends BaseTest {

    @Test
    public void getPosts() {
        given()
                .spec(reqSpec)
        .when()
                .get()
        .then()
                .spec(respSpec)
                .assertThat().body("userId[1]",Matchers.equalTo(1))
                .assertThat().body("title[1]", Matchers.equalTo("qui est esse"))
        .and()
                .assertThat().body("userId[36]",Matchers.equalTo(4))
                .assertThat().body("title[36]",Matchers.equalTo("provident vel ut sit ratione est"))
        .and()
                .assertThat().body("userId[99]",Matchers.equalTo(10))
                .assertThat().body("title[99]",Matchers.equalTo("at nam consequatur ea labore ea harum"));
    }
}
