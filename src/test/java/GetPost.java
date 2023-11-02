import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class GetPost extends BaseTest {

    @Test
    public void getPost(){
        given()
                .pathParam("id","2")
                .spec(reqSpec)
        .when()
                .get("{id}")
        .then()
                .spec(respSpec)
                .assertThat().body("userId", Matchers.equalTo(1))
                .assertThat().body("title", Matchers.equalTo("qui est esse"));
    }
}
