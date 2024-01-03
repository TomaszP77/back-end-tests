package restassured.learning;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import restassured.learning.model.Album;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class VerifyResponse {

    @Test
    public void verifyResponse() {
        String expected = "{\n" +
                "  \"userId\": 1,\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"delectus aut autem\",\n" +
                "  \"completed\": false\n" +
                "}";

        given()
                .log().all()
        .when()
                .get("https://jsonplaceholder.typicode.com/todos/{id}",1)
        .then()
                .log().all()
                .body(equalTo(expected));
    }

    @Test
    public void verifyResponseContainsString() {
        given()
                .log().all()
        .when()
                .get("https://jsonplaceholder.typicode.com/todos/{id}",1)
        .then()
                .log().all()
                .body(Matchers.containsString("delectus aut autem"));
    }

    @Test
    public void verifyResponseContainsStringIgnoringCase() {
        given()
                .log().all()
        .when()
                .get("https://jsonplaceholder.typicode.com/todos/{id}",1)
        .then()
                .log().all()
                .body(Matchers.containsStringIgnoringCase("DELECTUS AUT AUTEM"));
    }

    @Test
    public void verifyResponseCheckSpecificField() {
        given()
                .log().all()
        .when()
                .get("https://jsonplaceholder.typicode.com/todos/{id}", 1)
        .then()
                .log().all()
                .assertThat().body("title", equalTo("delectus aut autem"))
                .assertThat().body("completed", equalTo(false));
    }

    @Test
    public void getAlbumObject() {
        Integer id = 5;

        Album newAlbum = given()
                            .log().all()
                        .when()
                            .get("https://jsonplaceholder.typicode.com/albums/{id}", 5)
                        .then()
                            .log().all()
                            .assertThat().body("userId", equalTo(1))
                            .assertThat().body("title", equalTo("eaque aut omnis a"))
                            .extract().body().as(Album.class);

        Assertions.assertEquals(1, newAlbum.getUserId());
        Assertions.assertEquals(5,id);
        Assertions.assertEquals("eaque aut omnis a", newAlbum.getTitle());
    }
}
