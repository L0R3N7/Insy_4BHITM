package at.htl;

import at.htl.models.PersonDTO;
import at.htl.workloads.person.Gender;
import at.htl.workloads.person.Person;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
public class PersonResrouceTest {

    static final String resourceString = "person";

    @Test
    public void testAddPerson(){
        PersonDTO personDTO = new PersonDTO();
        personDTO.setAwesome(false);
        personDTO.setFirstName("Lorenz");
        personDTO.setLastName("Litzlbauer");
        personDTO.setGender(Gender.Male);

        given()
                .header("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .body(personDTO).
        when()
                .post(resourceString).
        then()
                .statusCode(200)
                .body("awesome", equalTo(personDTO.getAwesome())
                , "firstName", equalTo(personDTO.getFirstName())
                , "lastName", equalTo(personDTO.getLastName()));
    }

    @Test
    public void testGetCountAwesomeness(){
        when()
                .get(resourceString+"/count/awesomeness")
                .then()
                .statusCode(200).equals(2);
    }

    @Test
    public void testAddAddress(){
        given()
                .pathParam("personId", 2)
                .pathParam("addressId", 1).
        when()
                .post(resourceString+"{personId}/address/{addressId}").
        then()
                .statusCode(200);
    }
}
