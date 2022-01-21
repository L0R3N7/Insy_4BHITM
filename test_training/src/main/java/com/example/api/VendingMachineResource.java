package com.example.api;

import com.example.workloads.VendingMachine.logik.VendingMachineService;

import javax.annotation.processing.Generated;
import javax.persistence.GeneratedValue;
import javax.print.attribute.standard.Media;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
}
