package at.htl.api;

import at.htl.models.InterestDTO;
import at.htl.models.PersonDTO;
import at.htl.workloads.address.Address;
import at.htl.workloads.address.AddressService;
import at.htl.workloads.hobbies.Hobby;
import at.htl.workloads.hobbies.HobbyService;
import at.htl.workloads.person.Person;
import at.htl.workloads.person.PersonService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Produces("application/json")
@Consumes("application/json")
@Path("person")
public class PersonResource {

    private final PersonService personService;
    private final HobbyService hobbyService;
    private final AddressService addressService;

    public PersonResource(PersonService personService, HobbyService hobbyService, AddressService addressService) {
        this.personService = personService;
        this.hobbyService = hobbyService;
        this.addressService = addressService;
    }

    @GET
    @Path("all")
    public Response getAllPeople() {
        var allPeople = this.personService.getAll();
        return Response.ok(allPeople).build();
    }

    @GET
    @Path("{id}")
    public Response get(@PathParam("id") Long id) {
        Person person = this.personService.getPerson(id);
        return (person == null
                ? Response.status(404)
                : Response.ok(person))
                .build();
    }

    @GET
    @Path("count/awesomeness")
    public Response getCountAwesomeness(){
        return Response.ok(
                this.personService.getCountAwesomeness()
        ).build();
    }

    @POST
    @Path("{personId}/address/{addressId}")
    @Transactional
    public Response addAddress(
            @PathParam("personId") long pid,
            @PathParam("addressId") long aid
    ){
        Person person = this.personService.getPerson(pid);
        Address address = this.addressService.getAddress(aid);

        if (person == null || address == null){
            return Response.status(404).build();
        }

        this.personService.addAddress(person, address);

        return Response.ok().build();
    }

    @POST
    @Path("{personId}/hobby")
    @Transactional
    public Response addHobby(@PathParam("personId") Long id,
                             InterestDTO newInterest){
        Person person = this.personService.getPerson(id);
        Hobby hobby = this.hobbyService.getHobby(newInterest.getHobbyId());
        if (person == null || hobby == null){
            return Response.status(404).build();
        }

        this.personService.addHobby(person, hobby, newInterest.getAmateur());
        return Response.ok().build();
    }





    @DELETE
    @Path("{personId}/hobby/{hobbyId}")
    @Transactional
    public Response removeHobby(@PathParam("personId") Long personId,
                                @PathParam("hobbyId") Long hobbyId){
        Person person = this.personService.getPerson(personId);
        Optional<Hobby> hobby = Optional.empty();
        /*        if (person != null){
            hobby = person.getInterests()
                    .stream()
                    .filter(h -> Objects.equals(h.getId(), hobbyId))
                    .findFirst();
        }*/
        if (person != null && hobby.isPresent()){
            this.personService.removeHobby(person, hobby.get());
        }
        return Response.ok().build();
    }

    @POST
    @Transactional
    public Response addPerson(PersonDTO newPerson){
        return Response.ok(this.personService.addPerson(
                newPerson.getFirstName(),
                newPerson.getLastName(),
                newPerson.getDateOfBirth(),
                newPerson.getGender(),
                newPerson.getAwesome())
        ).build();
    }

}

