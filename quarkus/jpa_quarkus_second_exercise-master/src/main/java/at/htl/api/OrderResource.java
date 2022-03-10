package at.htl.api;

import at.htl.models.OrderDTO;
import at.htl.models.OrderItemDTO;
import at.htl.workloads.order.NewOrderItem;
import at.htl.workloads.order.Orderr;
import at.htl.workloads.order.logic.OrderrService;
import at.htl.workloads.person.PersonService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("order")
public class OrderResource {

    private final OrderrService orderrService;
    private final PersonService personService;

    public OrderResource(OrderrService orderrService, PersonService personService) {
        this.orderrService = orderrService;
        this.personService = personService;
    }

    @PUT
    @Transactional
    @Path("{Order_Id}")
    public Response updateOrder(
            @PathParam("Order_Id") long id,
            List<OrderItemDTO> orderItemDTOList
    ){
        Orderr orderr = orderrService.getOrderr(id);

        if (orderr == null){return Response.status(404).build();}

        orderrService.update(orderr, orderItemDTOList);

        return Response.ok().build();
    }

    @DELETE
    @Transactional
    @Path("{Order_id}")
    public Response deleteOrder(
            @PathParam("Order_id") long id
    ){
        if (orderrService.getOrderr(id) == null){
            return Response.status(404).build();
        }
        return ((orderrService.deleteOrder(id))?
                (Response.ok()):
                (Response.notModified())).build();
    }

    @POST
    @Transactional
    public Response addOrder(OrderDTO newOrder){
        var person = this.personService.getPerson(newOrder.getPersonId());
        if (person == null){
            return Response.status(404).build();
        }
        // des is mega verwirrend ヽ༼ ಠ益ಠ ༽ﾉ, aber ja
        var order = this.orderrService.addOrder(person, newOrder.getItems()
                .stream()
                // we don't want to hand DTOs to a service
                // sadly records also have to have their own file in Java, so a little verbose...
                // alternative: https://www.javatuples.org/ but with unnamed fields...
                .map(oi -> new NewOrderItem(oi.getpCode(), oi.getpPrice(), oi.getAmount()))
                .toList()
        );
        return Response.ok().build();
    }

    @GET
    @Path("{order_id}")
    public Response getOrderr(
            @PathParam("order_id") long id
    ){
        Orderr orderr = this.orderrService.getOrderr(id);

        return ((orderr == null)
                ?(Response.status(404))
                : (Response.ok(orderr))).build();
    }

    @GET
    @Path("AllTotalRevenue")
    public Response getAllTotalRevenue(){

        return Response.ok(
                this.orderrService.getAllTotalRevenue()
        ).build();
    }
}