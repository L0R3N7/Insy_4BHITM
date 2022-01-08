package at.htl.api;


import at.htl.models.OrderDTO;
import at.htl.models.OrderItemDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;


import static io.restassured.RestAssured.given;

@QuarkusTest
class OrderResourceTest {

    @Inject
    protected UserTransaction transaction;

    private final String url = "order";
    static OrderItemDTO orderItemDTO;
    static List<OrderItemDTO> orderItemDTOList;
    static OrderDTO orderDTO;

    @BeforeAll
    static void init(){
        orderItemDTO = new OrderItemDTO();
        orderItemDTO.setpPrice(BigDecimal.valueOf(5));
        orderItemDTO.setAmount(4);
        orderItemDTO.setpCode(9);
        orderItemDTOList = new ArrayList<>();
        orderItemDTOList.add(orderItemDTO);
        orderDTO = new OrderDTO();
        orderDTO.setItems(orderItemDTOList);
        orderDTO.setPersonId(1L);
    }

    @BeforeEach
    public void beginTransaction() throws SystemException, NotSupportedException {
        transaction.begin();
    }

    @AfterEach
    public void rollbackTransaction() throws SystemException {
        transaction.rollback();
    }

    @Test
    void updateOrder() {
        given()
                .header("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .body(orderDTO.getItems()).
                when().put(url+"/999").then().statusCode(404);
    }

    @Test
    void deleteOrder() {
        testAddOrder();
        given()
                .header("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                when()
                .delete(url+"/1").
                then().statusCode(200);

    }

    @Test
    void testGetOrder() {
        testAddOrder();

        given()
                .header("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                when()
                .get(url+"/1").
                then().statusCode(200);

    }

    @Test
    void testAddOrder(){
        given()
                .header("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .body(orderDTO).
                when()
                .post(url).
                then().statusCode(200);
    }


    @Test
    void getAllTotalRevenue() {
        testAddOrder();

        given()
                .header("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                when()
                .get(url+"/AllTotalRevenue").
                then().statusCode(200);
    }

}