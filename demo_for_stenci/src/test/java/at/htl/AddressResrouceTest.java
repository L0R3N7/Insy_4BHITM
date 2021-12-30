package at.htl;

import at.htl.models.AddressDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class AddressResrouceTest {

    static final String resourceString = "address";

    @Test
    public void addAddress(){
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity("Linz");
        addressDTO.setPost(4020);
        addressDTO.setStreet("Taubenmarkt");
        addressDTO.setStreetNr(43);

        given()
                .header("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .body(addressDTO).
        when()
                .post(resourceString).
        then()
                .statusCode(200)
                .body(
                        "city", equalTo(addressDTO.getCity()),
                        "post", equalTo(addressDTO.getPost()),
                        "street", equalTo(addressDTO.getStreet()),
                        "streetNr", equalTo(addressDTO.getStreetNr())
                );
    }

    @Test
    public void testGetAllCities(){
        when()
                .get(resourceString+"/all/city").
        then()
                .statusCode(200);
    }
}
