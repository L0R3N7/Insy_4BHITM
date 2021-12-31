package at.htl.api;

import at.htl.models.InterestDTO;
import at.htl.models.PersonDTO;
import at.htl.workloads.hobby.Hobby;
import at.htl.workloads.hobby.HobbyService;
import at.htl.workloads.order.Orderr;
import at.htl.workloads.person.Person;
import at.htl.workloads.person.PersonService;

import javax.transaction.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("person")
public class PersonResource {

    private final PersonService personService;
    private final HobbyService hobbyService;

    public PersonResource(PersonService personService, HobbyService hobbyService) {
        this.personService = personService;
        this.hobbyService = hobbyService;
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

    @POST
    @Path("{personId}/interest")
    @Transactional
    public Response addInterest(@PathParam("personId") Long id,
                             InterestDTO newInterest){
        Person person = this.personService.getPerson(id);
        Hobby hobby = this.hobbyService.getHobby(newInterest.getHobbyId());
        if (person == null || hobby == null){
            return Response.status(404).build();
        }
        this.personService.addHobby(person, hobby, newInterest.getAmateur());
        return Response.ok().build();
    }

    @POST
    @Transactional
    public Response addPerson(PersonDTO newPerson){
        return Response.ok(this.personService.addPerson(
                newPerson.getFirstName(),
                newPerson.getLastName(),
                newPerson.getDateOfBirth(),
                newPerson.getGender())).build();
    }

    @GET
    @Path("{person_id}/numberOfOrders")
    public Response numberOfOrders(
            @PathParam("person_id") long id
    ){
        long count = this.personService.numberOfOrders(id);
        return Response.ok(count).build();
    }
}
