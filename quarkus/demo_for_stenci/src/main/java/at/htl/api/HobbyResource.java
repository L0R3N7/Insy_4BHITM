package at.htl.api;

import at.htl.models.HobbyDTO;
import at.htl.workloads.hobbies.HobbyService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Map;

@Produces("application/json")
@Consumes("application/json")
@Path("hobby")
public class HobbyResource {

    private final HobbyService hobbyService;

    public HobbyResource(HobbyService hobbyService) {
        this.hobbyService = hobbyService;
    }

    @POST
    @Transactional
    public Response addHobby(HobbyDTO newHobby){
        return Response.ok(this.hobbyService.addHobby(
                newHobby.getDescription(),
                newHobby.getOutdoor()
        )).build();
    }

    @GET
    @Path("all/stats")
    public Response getHobbyIsCount(){
        Map<String, Long> counts = this.hobbyService.getHobbyIsCount();
        return Response.ok(counts).build();
    }


}
