package at.htl.api;

import at.htl.models.HobbyDTO;
import at.htl.models.OrderDTO;
import at.htl.models.OrderItemDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.junit.jupiter.api.*;
import org.mockito.internal.matchers.Or;

import javax.inject.Inject;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


@QuarkusTest
class HobbyResourceTest {

    @Inject
    protected UserTransaction transaction;

    static String url = "hobby";

    static HobbyDTO hobbyDTO;

    @BeforeEach
    void transactionBegin() throws SystemException, NotSupportedException {
        transaction.begin();
    }

    @AfterEach
    void transactionRollback() throws SystemException {
        transaction.rollback();
    }

    @BeforeAll
    static void init(){
        hobbyDTO = new HobbyDTO();
        hobbyDTO.setOutdoor(true);
        hobbyDTO.setDescription("Skiing");
    }

    @Test
    void addHobby() {
        given()
                .header("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .body(hobbyDTO).
                when()
                .post(url).
                then().statusCode(200);
    }

    @Test
    void getHobbyistCount() {
        given()
                .header("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                .get(url+"/all/stats").
                then().statusCode(200);
    }

    @Test
    void theMostPopularItemPerHobby() {
        given()
                .header("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .when()
                .get(url+"/TheMostPopularItemPerHobby").
                then().statusCode(200);
    }
}