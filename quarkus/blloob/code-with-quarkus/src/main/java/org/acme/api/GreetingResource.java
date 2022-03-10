package org.acme.api;

import org.acme.workloads.hobbies.Gender;
import org.acme.workloads.hobbies.Person;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;

@Path("/hello")
public class GreetingResource {

    @Inject
    private EntityManager entityManager;


    @Transactional
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        Person newPerson = new Person();
        newPerson.setFirsName("Ian");
        newPerson.setLastName("Litzlbauer");
        newPerson.setDateOfBirth(LocalDate.of(2004,2,2));
        newPerson.setGender(Gender.Male);

        newPerson.addHobby("reiten", true);

        //newPerson.removeHobby(1L);

        entityManager.persist(newPerson);
        return "Hello RESTEasy";
    }
}

//gRPC für Streaming
//Protocoll Buffers