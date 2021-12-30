package at.htl.api;

import at.htl.models.OrderDTO;
import at.htl.workloads.order.NewOrderItem;
import at.htl.workloads.order.OrderrService;
import at.htl.workloads.person.PersonService;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    @POST
    @Transactional
    public Response addOrder(OrderDTO newOrder){
        var person = this.personService.getPerson(newOrder.getPersonId());
        if (person == null){
            return Response.status(404).build();
        }
        // des is mega verwirrend ヽ༼ ಠ益ಠ ༽ﾉ
        var order = this.orderrService.addOrder(person, newOrder.getItems()
                .stream()
                // we don't want to hand DTOs to a service
                // sadly records also have to have their own file in Java, so a little verbose...
                // alternative: https://www.javatuples.org/ but with unnamed fields...
                .map(oi -> new NewOrderItem(oi.getpCode(), oi.getpPrice(), oi.getAmount()))
                .toList()
        );



        return Response.ok(order).build();
    }
}