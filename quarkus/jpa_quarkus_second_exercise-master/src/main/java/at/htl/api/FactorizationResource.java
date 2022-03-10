package at.htl.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("Factorization")
@Produces(MediaType.APPLICATION_JSON)
public class FactorizationResource {

    @Path("/{number}")
    @GET
    public Response getFactorization(
            @PathParam("number") Long number
    ){
        long fact = 1L;
        for (int i = 1; i < number+1;  i++){
            fact = fact * i;
        }
        return Response.ok(fact).build();
    }

}
