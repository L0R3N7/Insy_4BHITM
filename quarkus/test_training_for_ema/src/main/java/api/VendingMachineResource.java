package api;

import workloads.vendingmachine.VendingMachineService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("vendingmachine")
public class VendingMachineResource {

    private final VendingMachineService service;

    public VendingMachineResource(VendingMachineService service) {
        this.service = service;
    }

    @GET
    @Path("all")
    public Response getAll(){
        var allMachines = this.service.getAll();
        return Response.ok(allMachines).build();
    }

}
