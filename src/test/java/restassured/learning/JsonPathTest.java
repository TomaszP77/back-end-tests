package restassured.learning;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JsonPathTest {

    @Test
    public void checkSpecificFieldJsonPath() {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users/");

        List<String> userList = response.path("name");
        System.out.println(userList);
        String name3 = response.path("name[3]");
        System.out.println(name3);
        List<String> zipCode = response.path("address.zipcode");
        System.out.println(zipCode);
        String zipCode3 = response.path("address[3].zipcode");
        System.out.println(zipCode3);
    }
}
