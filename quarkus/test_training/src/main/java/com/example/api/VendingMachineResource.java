package com.example.api;

import com.example.workloads.VendingMachine.VendingMachine;
import com.example.workloads.VendingMachine.logik.VendingMachineService;

import javax.annotation.processing.Generated;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("vendingmachine")
@Generated(MediaType.APPLICATION_JSON)
public class VendingMachineResource {

    private final VendingMachineService service;

    public VendingMachineResource(VendingMachineService service) {
        this.service = service;
    }

    @GET
    @Path("all")
    public Response getAll(){
        return Response.ok(this.service.getAll()).build();
    }

    @GET
    @Path("all/mostExpensiveProduct")
    public Response getAllMostExpensiveProduct(){
        return Response.ok().build();
    }

    @DELETE
    @Transactional
    @Path("{id}")
    public Response deleteById(
            @PathParam("id") long id
    ){
        VendingMachine vendingMachine = this.service.getById(id);
        if (vendingMachine == null){
            return Response.status(404).build();
        }
        this.service.delete(vendingMachine);
        return Response.ok().build();
    }
}
