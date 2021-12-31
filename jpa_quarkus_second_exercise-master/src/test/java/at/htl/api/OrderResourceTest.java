package at.htl.api;


import at.htl.models.OrderDTO;
import at.htl.models.OrderItemDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

@QuarkusTest
class OrderResourceTest {

    private final String url = "order";
    OrderItemDTO orderItemDTO;
    List<OrderItemDTO> orderItemDTOList;
    OrderDTO orderDTO;

    @BeforeAll
    void init(){
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

    @Test
    void updateOrder() {

    }

    @Test
    void deleteOrder() {
    }

    @Test
    void testGetAddOrder() {
        given()
                .header("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .body(orderDTO).
        when()
                .post(url).
        then().statusCode(200);
    }


    @Test
    void getAllTotalRevenue() {
    }

}