package org.acme.api;

import org.acme.models.HobbyDTO;
import org.acme.models.PersonDTO;
import org.acme.workloads.hobbies.Hobby;
import org.acme.workloads.hobbies.PersonService;
import org.graalvm.nativeimage.c.struct.RawField;
import org.hibernate.annotations.CreationTimestamp;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Objects;
import java.util.Optional;


@Path("person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersoneResrouce {

    private final PersonService service;

    public PersoneResrouce(PersonService service){
        this.service = service;
    }


    @GET
    @Path("all")
    public Response getAllPeople(){
        var allPeople = this.service.getAll();
        return Response.ok(allPeople).build();
    }

    @GET
    @Path("{id}")
    public Response getPerson(
            @PathParam("id") Long id
    ){
        var person = this.service.getPerson(id);
        return (person == null
                ? Response.status(404)
                : Response.ok(person))
                .build();
    }

    @POST
    @Path("{id}/hobby")
    @Transactional
    public Response addHobby(
            @PathParam("id") Long id,
            HobbyDTO newHobby
    ){
        var person = this.service.getPerson(id);
        if (person == null){
            return Response.status(404).build();
        }

        this.service.addHobby(person, newHobby.getDescription(), newHobby.getOutdoor());
        return Response.ok().build();
    }

    @DELETE
    @Path("{personId}/hobby/{hobbyId}")
    @Transactional
    public Response removeHobby(
            @PathParam("personId") Long personId,
            @PathParam("hobbyId") Long hobbyId
    ){
        var p = this.service.getPerson(personId);
        Optional<Hobby> hobby = null;

        if (p != null){
            hobby = p.getHobbyList()
                    .stream()
                    .filter(h -> Objects.equals(h.getId(), hobbyId))
                    .findFirst();
        }

        if (p != null && hobby.isPresent()){
            this.service.removeHobby(p, hobby.get());
        }
        return Response.ok().build();
    }

    @POST
    @Transactional
    public Response addPerson(
            PersonDTO newPerson
    ){
        return Response.ok(this.service.addPerson(newPerson.getFirsName(),
                newPerson.getLastName(),
                newPerson.getDateOfBirth(),
                newPerson.getGender())).build();
    }


}
