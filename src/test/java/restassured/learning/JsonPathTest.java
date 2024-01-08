package restassured.learning;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JsonPathTest {

    @Test
    public void checkSpecificFieldJsonPathUsers() {
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

    @Test
    public void checkSpecificFieldJsonPathUser() {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users/2");

        String name = response.path("name");
        String username = response.path("username");
        String email = response.path("email");
        String addressStreet = response.path("address.street");
        String addressSuite = response.path("address.suite");
        String addressCity = response.path("address.city");
        String addressZipcode = response.path("address.zipcode");
        String addressGeoLat = response.path("address.geo.lat");
        String addressGeoLng = response.path("address.geo.lng");
        String phone = response.path("phone");
        String website = response.path("website");
        String companyName = response.path("company.name");
        String companyCatchPhrase = response.path("company.catchPhrase");
        String companyBs = response.path("company.bs");
    }
}
