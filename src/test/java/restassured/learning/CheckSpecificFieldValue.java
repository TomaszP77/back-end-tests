package restassured.learning;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckSpecificFieldValue {

    @Test
    public void checkSpecificField() {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users/1");
        String name = response.path("name");

        Assertions.assertEquals("Leanne Graham", name);
    }

    @Test
    public void checkSpecificFieldOtherForm() {
        String name = RestAssured.get("https://jsonplaceholder.typicode.com/users/1").path("name");

        Assertions.assertEquals("Leanne Graham", name);
    }

    @Test
    public void checkSpecificFieldJsonPath() {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users/1");
        JsonPath jsonPath = new JsonPath(response.asString());
        String name = jsonPath.get("name");

        Assertions.assertEquals("Leanne Graham", name);
    }
}
