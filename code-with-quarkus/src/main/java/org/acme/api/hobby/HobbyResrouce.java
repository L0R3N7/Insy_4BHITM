package org.acme.api.hobby;

import org.acme.models.HobbyDTO;
import org.acme.workloads.hobbies.HobbyService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("hobby")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HobbyResrouce {

    @Inject
    HobbyService hobbyService;


    @POST
    @Transactional
    public Response addHobby(HobbyDTO newHobby){
        return Response.ok(this.hobbyService.addHobby(
                newHobby.getDescription(),
                newHobby.getOutdoor()
        )).build();
    }
}
