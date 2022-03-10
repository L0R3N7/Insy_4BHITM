package org.acme.api;

import org.acme.models.PersonDTO;
import org.acme.workloads.hobbies.Hobby;
import org.acme.workloads.hobbies.HobbyService;
import org.acme.workloads.person.PersonService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Objects;
import java.util.Optional;


@Path("person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersoneResrouce {

    private final PersonService personService;
    private final HobbyService hobbyService;

    public PersoneResrouce(PersonService personService, HobbyService hobbyService){
        this.personService = personService;
        this.hobbyService = hobbyService;
    }


    @GET
    @Path("all")
    public Response getAllPeople(){
        var allPeople = this.personService.getAll();
        return Response.ok(allPeople).build();
    }

    @GET
    @Path("{id}")
    public Response getPerson(
            @PathParam("id") Long id
    ){
        var person = this.personService.getPerson(id);
        return (person == null
                ? Response.status(404)
                : Response.ok(person))
                .build();
    }

    @POST
    @Path("{id}/hobby")
    @Transactional
    public Response addHobby(
            @PathParam("personId") Long id,
            @PathParam("hobbyId") Long hobbyid;
    ){
        var person = this.personService.getPerson(id);
        if (person == null){
            return Response.status(404).build();
        }

        this.personService.addHobby(person, newHobby.getDescription(), newHobby.getOutdoor());
        return Response.ok().build();
    }

    @DELETE
    @Path("{personId}/hobby/{hobbyId}")
    @Transactional
    public Response removeHobby(
            @PathParam("personId") Long personId,
            @PathParam("hobbyId") Long hobbyId
    ){
        var p = this.personService.getPerson(personId);
        Optional<Hobby> hobby = null;

        if (p != null){
            hobby = p.getHobbyList()
                    .stream()
                    .filter(h -> Objects.equals(h.getId(), hobbyId))
                    .findFirst();
        }

        if (p != null && hobby.isPresent()){
            this.personService.removeHobby(p, hobby.get());
        }
        return Response.ok().build();
    }

    @POST
    @Transactional
    public Response addPerson(
            PersonDTO newPerson
    ){
        return Response.ok(this.personService.addPerson(newPerson.getFirsName(),
                newPerson.getLastName(),
                newPerson.getDateOfBirth(),
                newPerson.getGender())).build();
    }


}
