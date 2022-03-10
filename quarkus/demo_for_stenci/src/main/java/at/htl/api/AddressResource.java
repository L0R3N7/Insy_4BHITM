package at.htl.api;

import at.htl.models.AddressDTO;
import at.htl.workloads.address.AddressService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("address")
public class AddressResource {
    private final AddressService addressService;

    public AddressResource(AddressService addressService) {
        this.addressService = addressService;
    }


    @POST
    @Transactional
    public Response addAddress(AddressDTO addressDto){
        return Response.ok(
                this.addressService.addAddress(addressDto.getStreet(),
                        addressDto.getStreetNr(),
                        addressDto.getPost(),
                        addressDto.getCity())
        ).build();
    }

    @GET
    @Path("all/city")
    public Response getAllCities(){
        return Response.ok(this.addressService.getAllCities()).build();
    }


}
